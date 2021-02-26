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
    public void whenever호출수락함_(@Payload 호출수락함 호출수락함){

        if(호출수락함.isMe()){
            System.out.println("##### listener  : " + 호출수락함.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenever택시호출취소됨_(@Payload 택시호출취소됨 택시호출취소됨){

        if(택시호출취소됨.isMe()){
            System.out.println("##### listener  : " + 택시호출취소됨.toJson());
        }
    }

}
