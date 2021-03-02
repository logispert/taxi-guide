package taxiguider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import taxiguider.config.kafka.KafkaProcessor;

@Service
public class TaxicallPolicyHandler {
	@Autowired
	TaxicallRepository taxicallRepository;

	@StreamListener(KafkaProcessor.INPUT)
	public void onStringEventListener(@Payload String eventString) {

	}

	@StreamListener(KafkaProcessor.INPUT)
	public void wheneverTaxiassignCompleted_(@Payload TaxiassignCompleted taxiassignCompleted) {
		System.out.println("##### EVT TYPE[TaxiassignCompleted]  : " + taxiassignCompleted.getEventType());
		if (taxiassignCompleted.isMe() && taxiassignCompleted.getTel() != null) {

//           try {
//               // 원래 데이터가 트랜잭션 커밋되기도 전에 이벤트가 너무 빨리 도달하는 경우를 막기 위함
//               Thread.currentThread().sleep(3000); //  no good. --> pay 가 TX 를 마친 후에만 실행되도록 수정함
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
			System.out.println("##### listener[TaxiassignCompleted]  : " + taxiassignCompleted.toJson());
			

			// Correlation id 는 'tel' 임
			if(TaxiassignCompleted.getId() != null)
				TaxicallRepository.findById(Long.valueOf(taxiassignCompleted.getId())).ifPresent((taxicall) -> {
					taxicall.setStatus("호출확정");
					taxicallRepository.save(taxicall);
				});
//			TaxicallRepository.findBytel(TaxiassignCompleted.getTel()).ifPresent((Taxicall) -> {
//				System.out.println("taxiassignCompleted = " + TaxiassignCompleted.getTel());
//				Taxicall.setStatus("호출확정");
//				TaxicallRepository.save(Taxicall);
//			});
		}

//		if (TaxiassignCompleted.isMe()) {
//			Taxicall 호출 = new Taxicall();
//			호출.setStatus(TaxiassignCompleted.getStatus());
//			TaxicallRepository.save(호출);
//
//			System.out.println("##### listener[TaxiassignCompleted]  : " + TaxiassignCompleted.toJson());
//		}
	}

	@StreamListener(KafkaProcessor.INPUT)
	public void wheneverTaxiassignCancelled_(@Payload TaxiassignCancelled taxiassignCancelled) {
		System.out.println("##### EVT TYPE[TaxiassignCancelled]  : " + taxiassignCancelled.getEventType());
		if (taxiassignCancelled.isMe()) {
			System.out.println("##### listener[TaxiassignCancelled]  : " + taxiassignCancelled.toJson());
			taxicallRepository.findById(Long.valueOf(taxiassignCancelled.getId())).ifPresent((taxicall) -> {
				taxicall.setStatus("호출취소");
				taxicallRepository.save(taxicall);
			});
		}
	}

}
