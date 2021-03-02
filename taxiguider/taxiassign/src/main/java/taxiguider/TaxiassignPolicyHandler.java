package taxiguider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import taxiguider.config.kafka.KafkaProcessor;
import taxiguider.util.Assigner;

@Service
public class TaxiassignPolicyHandler{
	@Autowired TaxiassignRepository 할당Repository;
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }
    
    //private String status; //호출,호출중,호출확정,호출취소
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTaximanageAssigned_(@Payload TaximanageAssigned TaximanageAssigned){
    	System.out.println("##### EVT TYPE[TaximanageAssigned]  : " + TaximanageAssigned.getEventType());
        if(TaximanageAssigned.isMe()){
            System.out.println("##### listener  : " + TaximanageAssigned.toJson());
            
            if(TaximanageAssigned.getStatus() != null  && TaximanageAssigned.getStatus().equals("호출중"))
            {
            	
            	TaximanageAssigned.setStatus("호출확정");
            	//TaxiassignCompleted taxiassignCompleted = Assigner.getTaxiassign됨();
            	//BeanUtils.copyProperties(TaximanageAssigned, TaxiassignCompleted);
            	//TaxiassignCompleted.setEventType("TaxiassignCompleted");
            	TaximanageAssigned.publish();
            	
            	TaxiassignCompleted taxiassignCompleted = Assigner.getTaxiassign됨();
            	TaxiassignCompleted.setId(TaximanageAssigned.getId());
            	TaxiassignCompleted.setStatus("할당확정");
                TaxiassignCompleted.setTel(TaximanageAssigned.getTel());
                TaxiassignCompleted.setLocation(TaximanageAssigned.get고객위치());
            	TaxiassignCompleted.setEventType("TaxiassignCompleted");
            	//TaximanageAssigned.publishAfterCommit();
            	TaxiassignCompleted.publish();
            }  
        }
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTaxiassignCompleted_(@Payload TaxiassignCompleted TaxiassignCompleted){
    	System.out.println("##### EVT TYPE[TaxiassignCompleted]  : " + TaxiassignCompleted.getEventType());
        if(TaxiassignCompleted.isMe()){
            System.out.println("##### listener  : " + TaxiassignCompleted.toJson());
            
            if(TaxiassignCompleted.getStatus() != null  && TaxiassignCompleted.getStatus().equals("할당확정"))
            {
            	
//            	TaxiassignCompleted taxiassignCompleted = Assigner.getTaxiassign됨();
//            	BeanUtils.copyProperties(TaximanageAssigned, TaxiassignCompleted);
//            	
//                //TaxiassignCompleted.setEventType("TaxiassignCompleted");
//            	TaxiassignCompleted.setEventType("TaxiassignCompleted");
//            	//TaximanageAssigned.publishAfterCommit();
//            	TaxiassignCompleted.publish();
            }  
        }
    }
    
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTaximanageCancelled_(@Payload TaximanageCancelled TaximanageCancelled){
    	
        if(TaximanageCancelled.isMe()){
            System.out.println("##### listener  : " + TaximanageCancelled.toJson());
            
            
            할당Repository.findById(Long.valueOf(TaximanageCancelled.getId())).ifPresent((Taxicall) -> {
				Taxicall.setStatus("할당취소");
				할당Repository.save(Taxicall);
			});
            
            TaximanageCancelled.publish();
        }
    }

}
