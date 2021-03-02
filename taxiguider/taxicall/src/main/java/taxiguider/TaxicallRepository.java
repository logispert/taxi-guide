package taxiguider;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaxicallRepository extends PagingAndSortingRepository<Taxicall, Long>{

//	Optional<Taxicall> findBytel(String tel);
}