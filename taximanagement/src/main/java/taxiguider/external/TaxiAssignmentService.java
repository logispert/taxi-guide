
package taxiguider.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="taxiassignment", url="http://taxiassignment:8080")
public interface TaxiAssignmentService {

    @RequestMapping(method= RequestMethod.GET, path="/taxiAssignments")
    public void 택시호출취소(@RequestBody TaxiAssignment taxiAssignment);

}