package taxiguider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import taxiguider.config.kafka.KafkaProcessor;

@Service
public class 택시관리PolicyHandler{
	@Autowired 택시관리Repository 택시관리Repository;
	
	@StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }
	
    @StreamListener(KafkaProcessor.INPUT)
    public void whenever호출취소됨_(@Payload 호출취소됨 호출취소됨){
    	System.out.println("##### EVT TYPE[호출취소됨]  : " + 호출취소됨.getEventType());
        if(호출취소됨.isMe()){
            System.out.println("##### listener  : " + 호출취소됨.toJson());
        }
    }
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whenever택시할당요청됨_(@Payload 택시할당요청됨 택시할당요청됨){
    	System.out.println("##### EVT TYPE[택시할당요청됨]  : " + 택시할당요청됨.getEventType());
        if(택시할당요청됨.isMe()){
        	System.out.println("##### listener[할당확인됨]  : " + 택시할당요청됨.toJson());
			

			// Correlation id 는 '고객휴대폰번호' 임
        	택시관리Repository.findById(Long.valueOf(택시할당요청됨.getId())).ifPresent((택시관리) -> {
        		택시관리.set호출상태(택시할당요청됨.get호출상태());
				택시관리Repository.save(택시관리);
			});
        	택시관리Repository.findBy고객휴대폰번호(택시할당요청됨.get고객휴대폰번호()).ifPresent((택시관리) -> {
				System.out.println("택시할당요청됨 = " + 택시관리.get고객휴대폰번호());
				택시관리.set호출상태(택시할당요청됨.get호출상태());
				택시관리Repository.save(택시관리);
			});
//            택시관리 관리 = new 택시관리();
//            관리.set호출상태(할당확인됨.get호출상태());
//            관리.set택시기사이름(할당확인됨.get택시기사이름());
//            관리.set택시기사전화번호(할당확인됨.get택시기사전화번호());
//            관리.set택시번호(할당확인됨.get택시번호());
//            택시관리Repository.save(관리);
        }
    }
    
//    @StreamListener(KafkaProcessor.INPUT)
//    public void whenever택시할당확인됨_(@Payload 할당확인됨 할당확인됨){
//    	System.out.println("##### EVT TYPE[할당확인됨]  : " + 할당확인됨.getEventType());
//        if(할당확인됨.isMe()){
//            System.out.println("##### listener  : " + 할당확인됨.toJson());
//            택시관리 관리 = new 택시관리();
//            관리.set호출상태(할당확인됨.get할당상태());
//            관리.set택시기사이름(할당확인됨.get택시기사이름());
//            관리.set택시기사전화번호(할당확인됨.get택시기사전화번호());
//            관리.set택시번호(할당확인됨.get택시번호());
//            택시관리Repository.save(관리);
//        }
//    }
    
}
