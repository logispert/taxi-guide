package taxiguider.external;


public class 택시관리ServiceFallback implements 택시관리Service {
    
	@Override
	public void 택시할당요청(택시관리 택시관리) //, fallback = 결제이력ServiceFallback.class)
	{
		// TODO Auto-generated method stub
		System.out.println("Circuit breaker has been opened. Fallback returned instead.");
	}
}
