
package taxiguider.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name="taximanage", url="http://localhost:8082")
@FeignClient(name="taximanage", url="http://localhost:8082", fallback = TaximanageServiceFallback.class)
public interface TaximanageService {

    @RequestMapping(method= RequestMethod.POST, path="/Taximanages")
    public void TaximanageAssign(@RequestBody Taximanage Taximanage);

}