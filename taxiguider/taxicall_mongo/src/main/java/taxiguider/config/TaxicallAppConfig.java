package taxiguider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@Configuration
@EnableMongoAuditing
public class TaxicallAppConfig {
	@Bean
    public 택시호출RepositoryListener orderRepositoryListener() {
        return new 택시호출RepositoryListener();
    }

}
