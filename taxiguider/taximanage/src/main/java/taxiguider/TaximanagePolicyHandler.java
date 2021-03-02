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
	public void wheneverTaxicallCancelled_(@Payload TaxicallCancelled taxicallCancelled) {
		System.out.println("##### EVT TYPE[TaxicallCancelled]  : " + taxicallCancelled.getEventType());
		if (taxicallCancelled.isMe()) {
			System.out.println("##### listener  : " + taxicallCancelled.toJson());

			if (taxicallCancelled.getId() != null)
				// Correlation id 는 'tel' 임
				taximanageRepository.findById(Long.valueOf(taxicallCancelled.getId())).ifPresent((taximanage) -> {
					taximanage.setStatus("호출요청취소됨");
					taximanageRepository.save(taximanage);
				});
		}
	}

	@StreamListener(KafkaProcessor.INPUT)
	public void wheneverTaximanageAssigned_(@Payload TaximanageAssigned taximanageAssigned) {
		System.out.println("##### EVT TYPE[TaximanageAssigned]  : " + taximanageAssigned.getEventType());
		if (taximanageAssigned.isMe()) {
			System.out.println("##### listener[TaxiassignCompleted]  : " + taximanageAssigned.toJson());

			if (taximanageAssigned.getId() != null)
				// Correlation id 는 'tel' 임
				taximanageRepository.findById(Long.valueOf(taximanageAssigned.getId())).ifPresent((taximanage) -> {
					taximanage.setStatus(taximanageAssigned.getStatus());
					taximanageRepository.save(taximanage);
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
