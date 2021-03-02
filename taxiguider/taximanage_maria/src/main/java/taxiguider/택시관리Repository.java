package taxiguider;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaximanageRepository extends PagingAndSortingRepository<Taximanage, Long>{

	Optional<Taximanage> findBytel(String getTel);


}