package taxiguider;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaxicallinfoRepository extends CrudRepository<Taxicallinfo, Long> {


}