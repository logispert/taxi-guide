package taxiguider;

import taxiguider.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenever할당확인됨_(@Payload 할당확인됨 할당확인됨){

        if(할당확인됨.isMe()){
            System.out.println("##### listener  : " + 할당확인됨.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenever할당취소됨_(@Payload 할당취소됨 할당취소됨){

        if(할당취소됨.isMe()){
            System.out.println("##### listener  : " + 할당취소됨.toJson());
        }
    }

}
