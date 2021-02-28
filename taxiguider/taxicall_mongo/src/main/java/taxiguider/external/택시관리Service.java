
package taxiguider.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="taximanage", url="http://taximanage:8080")
public interface 택시관리Service {

    @RequestMapping(method= RequestMethod.GET, path="/택시관리")
    public void 택시할당요청(@RequestBody 택시관리 택시관리);

}