package taxiguider;

import org.bson.Document;
import org.springframework.beans.BeanUtils;
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
public class 택시호출RepositoryListener extends AbstractMongoEventListener<택시호출> {

	@Override
	public void onBeforeSave(BeforeSaveEvent<택시호출> event) {
		super.onBeforeSave(event);

		택시호출 order = event.getSource();
		Document d = event.getDocument();

		if (order.getId() == null) {
			// TODO use a better UUID generator in production
			d.put("_id", "" + (int) Math.floor(Math.random() * 100));
			// d.put("id","" + (int)Math.floor(Math.random()*100) );
		}

	}

	@Override
	public void onAfterSave(AfterSaveEvent<택시호출> event) {
		super.onAfterSave(event);
		택시호출 taxicall = event.getSource();

		// Following code causes dependency to external APIs
		// it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
		// System.out.println("===========================STATUS==" + ordr.get상태());

		// if(!"배달시작됨".equals(ordr.get상태()))
//		택시호출요청됨 택시호출요청됨 = new 택시호출요청됨();
//		BeanUtils.copyProperties(this, 택시호출요청됨);
//		택시호출요청됨.publishAfterCommit();

		// Following code causes dependency to external APIs
		// it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
		if(taxicall.get호출상태() == null)
		{
			택시관리 택시관리 = new 택시관리();
	        
			택시관리.setId(taxicall.getId());
	        택시관리.set휴대폰번호(taxicall.get휴대폰번호());
	        if(taxicall.get호출위치()!=null) 택시관리.set호출위치(taxicall.get호출위치());
	        if(taxicall.get호출상태()!=null) 택시관리.set호출상태(taxicall.get호출상태());
	        if(taxicall.get예상요금()!=null) 택시관리.set예상요금(taxicall.get예상요금());
	        
	        // mappings goes here
	        TaxicallApplication.applicationContext.getBean(택시관리Service.class).택시할당요청(택시관리);
		}
		
        
//		택시관리 택시관리 = new 택시관리();
//		// mappings goes here
//		TaxicallApplication.applicationContext.getBean(택시관리Service.class).택시할당요청(택시관리);

//      호출취소됨 호출취소됨 = new 호출취소됨();
//      BeanUtils.copyProperties(this, 호출취소됨);
//      호출취소됨.publishAfterCommit();
//		if(ordr.get상태() == null)
//		{
//			fooddelivery.external.결제이력 결제이력 = new fooddelivery.external.결제이력();
//
//	        // this is Context Mapping (Anti-corruption Layer)
//	        결제이력.setOrderId(String.valueOf(ordr.getId()));
//	        if(ordr.get가격()!=null)
//	            결제이력.set금액(Double.valueOf(ordr.get가격()));
//	        
//	        Application.applicationContext.getBean(fooddelivery.external.결제이력Service.class)
//	                .결제(결제이력);
//		}
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<택시호출> event) {
		// super.onBeforeConvert(event);

	}

	@Override
	public void onAfterLoad(AfterLoadEvent<택시호출> event) {

	}

	@Override
	public void onAfterDelete(AfterDeleteEvent<택시호출> event) {

	}

	@Override
	public void onAfterConvert(AfterConvertEvent<택시호출> event) {

	}

}