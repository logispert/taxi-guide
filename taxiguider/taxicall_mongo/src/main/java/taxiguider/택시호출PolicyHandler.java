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
	public void wheneverTaxiassignCompleted_(@Payload TaxiassignCompleted TaxiassignCompleted) {
		System.out.println("##### EVT TYPE[TaxiassignCompleted]  : " + TaxiassignCompleted.getEventType());
		if (TaxiassignCompleted.isMe() && TaxiassignCompleted.getTel() != null) {

//           try {
//               // 원래 데이터가 트랜잭션 커밋되기도 전에 이벤트가 너무 빨리 도달하는 경우를 막기 위함
//               Thread.currentThread().sleep(3000); //  no good. --> pay 가 TX 를 마친 후에만 실행되도록 수정함
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
			System.out.println("##### listener[TaxiassignCompleted]  : " + TaxiassignCompleted.toJson());
			

			// Correlation id 는 'tel' 임
			TaxicallRepository.findById(Long.valueOf(TaxiassignCompleted.getId())).ifPresent((Taxicall) -> {
				Taxicall.setStatus("호출확정");
				TaxicallRepository.save(Taxicall);
			});
			TaxicallRepository.findBytel(TaxiassignCompleted.getTel()).ifPresent((Taxicall) -> {
				System.out.println("taxiassignCompleted = " + TaxiassignCompleted.getTel());
				Taxicall.setStatus("호출확정");
				TaxicallRepository.save(Taxicall);
			});
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
	public void wheneverTaxiassignCancelled_(@Payload TaxiassignCancelled TaxiassignCancelled) {
		System.out.println("##### EVT TYPE[TaxiassignCancelled]  : " + TaxiassignCancelled.getEventType());
		if (TaxiassignCancelled.isMe()) {
			System.out.println("##### listener[TaxiassignCancelled]  : " + TaxiassignCancelled.toJson());
		}
	}

}
