package taxiguider;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import taxiguider.config.kafka.KafkaProcessor;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTaxiassignCompleted_(@Payload TaxiassignCompleted TaxiassignCompleted){

        if(TaxiassignCompleted.isMe()){
            System.out.println("##### listener  : " + TaxiassignCompleted.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTaxiassignCancelled_(@Payload TaxiassignCancelled TaxiassignCancelled){

        if(TaxiassignCancelled.isMe()){
            System.out.println("##### listener  : " + TaxiassignCancelled.toJson());
        }
    }

}
