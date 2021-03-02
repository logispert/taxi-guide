package taxiguider;

import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterLoadEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import taxiguider.external.택시관리;
import taxiguider.external.택시관리Service;

/**
 * Equivalent of a domain method annotated by <code>PrePersist</code>.
 * <p/>
 * This handler shows how to implement your custom UUID generation.
 * 
 * @author Tobias Trelle
 */
public class 택시호출RepositoryListener extends AbstractMongoEventListener<택시관리> {

	@Override
	public void onBeforeSave(BeforeSaveEvent<택시관리> event) {
		super.onBeforeSave(event);

		택시관리 taxiM = event.getSource();
		Document d = event.getDocument();
		System.out.println("===============>>>>>>=======================" + taxiM.getId());
		if (taxiM.getId() == null) {
			// TODO use a better UUID generator in production
			d.put("_id", "" + (int) Math.floor(Math.random() * 100));
			// d.put("id","" + (int)Math.floor(Math.random()*100) );
			taxiM.setId((long)Math.floor(Math.random() * 100));
		}

	}

	@Override
	public void onAfterSave(AfterSaveEvent<택시관리> event) {
		super.onAfterSave(event);
//      택시호출요청됨 택시호출요청됨 = new 택시호출요청됨();
//      BeanUtils.copyProperties(this, 택시호출요청됨);
//      택시호출요청됨.publishAfterCommit();
		택시관리 taxiM = event.getSource();
		System.out.println("휴대폰번호 " + taxiM.getTel());
		System.out.println("호출위치 " + taxiM.getLocation());
		System.out.println("호출상태 " + taxiM.get호출상태());
		System.out.println("예상요금 " + taxiM.getCost());
		// Following code causes dependency to external APIs
		// it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
		if (taxiM.getTel() != null) {
			System.out.println("SEND###############################" + taxiM.getId());
			택시관리 택시관리 = new 택시관리();

			택시관리.setOrderId(String.valueOf(taxiM.getId()));
			택시관리.setTel(taxiM.getTel());
			if (taxiM.getLocation() != null)
				택시관리.setLocation(taxiM.getLocation());
			if (taxiM.get호출상태() != null)
				택시관리.set호출상태(taxiM.get호출상태());
			if (taxiM.getCost() != null)
				택시관리.setCost(taxiM.getCost());

			// mappings goes here
			TaxicallApplication.applicationContext.getBean(택시관리Service.class).택시할당요청(택시관리);
		}

//      호출취소됨 호출취소됨 = new 호출취소됨();
//      BeanUtils.copyProperties(this, 호출취소됨);
//      호출취소됨.publishAfterCommit();
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<택시관리> event) {
		// super.onBeforeConvert(event);

	}

	@Override
	public void onAfterLoad(AfterLoadEvent<택시관리> event) {

	}

	@Override
	public void onAfterDelete(AfterDeleteEvent<택시관리> event) {

	}

	@Override
	public void onAfterConvert(AfterConvertEvent<택시관리> event) {

	}

}