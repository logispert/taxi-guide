package taxiguider.external;

import org.springframework.stereotype.Component;

@Component
public class TaximanageServiceFallback implements TaximanageService {
	 
	//@Override
	//public void TaximanageAssign(Taximanage Taximanage)
	//{	
	//	System.out.println("Circuit breaker has been opened. Fallback returned instead.");
	//}
	
	
	@Override
	public void TaximanageAssign(Taximanage taximanage) {
		// TODO Auto-generated method stub
		System.out.println("Circuit breaker has been opened. Fallback returned instead. " + taximanage.getId());
	}

}
