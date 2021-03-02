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
    public void wheneverTaximanageAssigned_(@Payload TaximanageAssigned taximanageAssigned){
    	System.out.println("##### EVT TYPE[TaximanageAssigned]  : " + taximanageAssigned.getEventType());
        if(taximanageAssigned.isMe()){
            System.out.println("##### listener  : " + taximanageAssigned.toJson());
            
            if(taximanageAssigned.getStatus() != null  && taximanageAssigned.getStatus().equals("호출중"))
            {

                taximanageAssigned.setStatus("호출확정");
            	//TaxiassignCompleted taxiassignCompleted = Assigner.getTaxiassign됨();
            	//BeanUtils.copyProperties(TaximanageAssigned, TaxiassignCompleted);
            	//TaxiassignCompleted.setEventType("TaxiassignCompleted");
                taximanageAssigned.publish();
            	
            	TaxiassignCompleted taxiassignCompleted = Assigner.getTaxiassignCompleted();
                taxiassignCompleted.setId(taximanageAssigned.getId());
                taxiassignCompleted.setStatus("할당확정");
                taxiassignCompleted.setTel(taximanageAssigned.getTel());
                taxiassignCompleted.setLocation(taximanageAssigned.get고객위치());
                taxiassignCompleted.setEventType("TaxiassignCompleted");
            	//TaximanageAssigned.publishAfterCommit();
                taxiassignCompleted.publish();
            }  
        }
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTaxiassignCompleted_(@Payload TaxiassignCompleted taxiassignCompleted){
    	System.out.println("##### EVT TYPE[TaxiassignCompleted]  : " + taxiassignCompleted.getEventType());
        if(taxiassignCompleted.isMe()){
            System.out.println("##### listener  : " + taxiassignCompleted.toJson());
            
            if(taxiassignCompleted.getStatus() != null  && taxiassignCompleted.getStatus().equals("할당확정"))
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
    public void wheneverTaximanageCancelled_(@Payload TaximanageCancelled taximanageCancelled){
    	
        if(taximanageCancelled.isMe()){
            System.out.println("##### listener  : " + taximanageCancelled.toJson());


            taxiassignRepository.findById(Long.valueOf(TaximanageCancelled.getId())).ifPresent((taxicall) -> {
                taxicall.setStatus("할당취소");
                taxiassignRepository.save(taxicall);
			});

            taximanageCancelled.publish();
        }
    }

}
