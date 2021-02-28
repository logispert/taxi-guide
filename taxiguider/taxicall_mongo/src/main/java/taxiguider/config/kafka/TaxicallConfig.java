package taxiguider.config.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import taxiguider.택시호출RepositoryListener;


@Configuration
@EnableMongoAuditing
public class TaxicallConfig {
	@Bean
    public 택시호출RepositoryListener orderRepositoryListener() {
        return new 택시호출RepositoryListener();
    }

}
