package taxiguider;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface 택시관리Repository extends PagingAndSortingRepository<택시관리, Long>{

	Optional<택시관리> findBy고객휴대폰번호(String getTel);


}