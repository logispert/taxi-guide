
package taxiguider.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="taximanage", url="http://localhost:8082")
public interface 택시관리Service {

    @RequestMapping(method= RequestMethod.POST, path="/택시관리s")
    public void 택시할당요청(@RequestBody 택시관리 택시관리);

    @RequestMapping(method= RequestMethod.POST, path="/택시관리s")
    public void 택시할당요청(@RequestBody 택시관리 택시관리);

}