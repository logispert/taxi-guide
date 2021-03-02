package taxiguider;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaxicallRepository extends PagingAndSortingRepository<Taxicall, Long>{

	Optional<Taxicall> findBytel(String tel);


}