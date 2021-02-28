package taxiguider;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface 택시호출Repository extends PagingAndSortingRepository<택시호출, Long>{

	Optional<택시호출> findBy휴대폰번호(String 휴대폰번호);


}