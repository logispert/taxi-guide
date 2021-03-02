package taxiguider.external;


public class TaximanageServiceFallback implements TaximanageService {
    
	@Override
	public void TaximanageAssign(Taximanage Taximanage) //, fallback = 결제이력ServiceFallback.class)
	{
		// TODO Auto-generated method stub
		System.out.println("Circuit breaker has been opened. Fallback returned instead.");
	}
}
