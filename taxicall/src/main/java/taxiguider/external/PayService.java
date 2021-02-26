
package taxiguider.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="payment", url="http://payment:8080")
public interface PayService {

    @RequestMapping(method= RequestMethod.GET, path="/pays")
    public void 요금결재(@RequestBody Pay pay);

}