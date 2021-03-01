package taxiguider.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import taxiguider.택시호출;
import taxiguider.택시호출Repository;

@Component
public class 택시관리ServiceFallback implements 택시관리Service {
	@Autowired
	택시호출Repository 택시호출Repository;

	@Override
	public void 택시할당요청(택시관리 택시관리) {
		// TODO Auto-generated method stub
		System.out.println("Circuit breaker has been opened. Fallback returned instead." + 택시관리.getId());
		//택시호출 호출 = new 택시호출();
		//호출.set휴대폰번호(택시관리.get고객휴대폰번호());
		//호출.setId(택시관리.getId());
		//호출.set호출상태("service_fallback");
		
		//택시호출Repository.save(호출);
		
		택시호출Repository.findById(Long.valueOf(택시관리.getId())).ifPresent((택시호출) -> {
			System.out.println("2. Circuit breaker has been opened. Fallback returned instead." + 택시관리.getId());
			택시호출.set호출상태("service_fallback");
			택시호출Repository.save(택시호출);
		});
		택시호출Repository.findById(Long.valueOf(택시관리.getId()-1)).ifPresent((택시호출) -> {
			System.out.println("2. Circuit breaker has been opened. Fallback returned instead." + 택시관리.getId());
			택시호출.set호출상태("service_fallback");
			택시호출Repository.save(택시호출);
		});
	}
    
	//@Override
	//public void 택시할당요청(택시관리 택시관리) //, fallback = 결제이력ServiceFallback.class)
	//{
	//	// TODO Auto-generated method stub
	//	System.out.println("Circuit breaker has been opened. Fallback returned instead.");
	//}
	
	//@Override
	//public void 택시할당요청(택시관리 택시관리, fallback = 결제이력ServiceFallback.class)
	//{
		// TODO Auto-generated method stub
	//	System.out.println("Circuit breaker has been opened. Fallback returned instead.");
	//}
}
