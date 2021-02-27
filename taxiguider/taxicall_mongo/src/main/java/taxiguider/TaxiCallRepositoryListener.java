package taxiguider;

import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterLoadEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import taxiguider.external.TaxiManagement;
import taxiguider.external.TaxiManagementService;

/**
 * Equivalent of a domain method annotated by <code>PrePersist</code>.
 * <p/>
 * This handler shows how to implement your custom UUID generation.
 * @author Tobias Trelle
 */
public class TaxiCallRepositoryListener extends AbstractMongoEventListener<TaxiCall>  {

	@Override
	public void onBeforeSave(BeforeSaveEvent<TaxiCall> event) {
		super.onBeforeSave(event);
		
		TaxiCall tcall = event.getSource();
		Document d = event.getDocument();
		
		if ( tcall.getId() == null ) {
			// TODO use a better UUID generator in production
			d.put("_id","" + (int)Math.floor(Math.random()*100) );
			//d.put("id","" + (int)Math.floor(Math.random()*100) );
		}
		
	}
	
	@Override
    public void onAfterSave(AfterSaveEvent<TaxiCall> event){
		super.onAfterSave(event);
		TaxiCall tcall = event.getSource();
		
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.
		//System.out.println("===========================STATUS==" + ordr.get상태());
        
		//if(!"배달시작됨".equals(ordr.get상태()))
		//if(tcall.get상태() == null)
		{
			TaxiManagement 고객정보 = new TaxiManagement();

	        // this is Context Mapping (Anti-corruption Layer)
			//고객정보.setOrderId(String.valueOf(tcall.getId()));
	        //if(ordr.get가격()!=null)
	        //	고객정보.set금액(Double.valueOf(tcall.get가격()));
	        
	        TaxicallApplication.applicationContext.getBean(TaxiManagementService.class).택시할당요청(고객정보);
		}
    }
	
	@Override
	public void onBeforeConvert(BeforeConvertEvent<TaxiCall> event)
	{
		//super.onBeforeConvert(event);
		
		
	}
	
	@Override
	public void onAfterLoad(AfterLoadEvent<TaxiCall> event)
	{
		
	}
	
	@Override
	public void onAfterDelete(AfterDeleteEvent<TaxiCall> event)
	{

	}
	
	
	@Override
	public void onAfterConvert(AfterConvertEvent<TaxiCall> event)
	{

	}
	
	

}