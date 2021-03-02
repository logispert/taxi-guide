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
    public void wheneverTaximanageAssigned_(@Payload TaximanageAssigned TaximanageAssigned){

        if(TaximanageAssigned.isMe()){
            System.out.println("##### listener  : " + TaximanageAssigned.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTaximanageCancelled_(@Payload TaximanageCancelled TaximanageCancelled){

        if(TaximanageCancelled.isMe()){
            System.out.println("##### listener  : " + TaximanageCancelled.toJson());
        }
    }

}
