package taxiguider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import taxiguider.config.kafka.KafkaProcessor;

@Service
public class TaximanagePolicyHandler {
	@Autowired
	TaximanageRepository taximanageRepository;

	@StreamListener(KafkaProcessor.INPUT)
	public void onStringEventListener(@Payload String eventString) {

	}

	@StreamListener(KafkaProcessor.INPUT)
	public void wheneverTaxicallCancelled_(@Payload TaxicallCancelled TaxicallCancelled) {
		System.out.println("##### EVT TYPE[TaxicallCancelled]  : " + TaxicallCancelled.getEventType());
		if (TaxicallCancelled.isMe()) {
			System.out.println("##### listener  : " + TaxicallCancelled.toJson());

			if (TaxicallCancelled.getId() != null)
				// Correlation id 는 'tel' 임
				TaximanageRepository.findById(Long.valueOf(TaxicallCancelled.getId())).ifPresent((Taximanage) -> {
					taximanage.setStatus("호출요청취소됨");
					TaximanageRepository.save(Taximanage);
				});
		}
	}

	@StreamListener(KafkaProcessor.INPUT)
	public void wheneverTaximanageAssigned_(@Payload TaximanageAssigned TaximanageAssigned) {
		System.out.println("##### EVT TYPE[TaximanageAssigned]  : " + TaximanageAssigned.getEventType());
		if (TaximanageAssigned.isMe()) {
			System.out.println("##### listener[TaxiassignCompleted]  : " + TaximanageAssigned.toJson());

			if (TaximanageAssigned.getId() != null)
				// Correlation id 는 'tel' 임
				TaximanageRepository.findById(Long.valueOf(TaximanageAssigned.getId())).ifPresent((Taximanage) -> {
					taximanage.setStatus(TaximanageAssigned.getStatus());
					TaximanageRepository.save(Taximanage);
				});

//        	TaximanageRepository.findBytel(TaximanageAssigned.getTel()).ifPresent((Taximanage) -> {
//				System.out.println("taximanageAssigned = " + taximanage.getTel());
//				taximanage.setStatus(TaximanageAssigned.getStatus());
//				TaximanageRepository.save(Taximanage);
//			});
//            Taximanage 관리 = new Taximanage();
//            관리.setStatus(TaxiassignCompleted.getStatus());
//            관리.setDriver(TaxiassignCompleted.getDriver());
//            관리.setDrivertel(TaxiassignCompleted.getDrivertel());
//            관리.setTaxiid(TaxiassignCompleted.getTaxiid());
//            TaximanageRepository.save(관리);
		}
	}

//    @StreamListener(KafkaProcessor.INPUT)
//    public void whenever택시TaxiassignCompleted_(@Payload TaxiassignCompleted TaxiassignCompleted){
//    	System.out.println("##### EVT TYPE[TaxiassignCompleted]  : " + TaxiassignCompleted.getEventType());
//        if(TaxiassignCompleted.isMe()){
//            System.out.println("##### listener  : " + TaxiassignCompleted.toJson());
//            Taximanage 관리 = new Taximanage();
//            관리.setStatus(TaxiassignCompleted.getStatus());
//            관리.setDriver(TaxiassignCompleted.getDriver());
//            관리.setDrivertel(TaxiassignCompleted.getDrivertel());
//            관리.setTaxiid(TaxiassignCompleted.getTaxiid());
//            TaximanageRepository.save(관리);
//        }
//    }

}
