package taxiguider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import taxiguider.택시호출RepositoryListener;

@Configuration
@EnableMongoAuditing
public class TaxicallAppConfig {
	@Bean
    public 택시호출RepositoryListener 택시호출RepositoryListener() {
        return new 택시호출RepositoryListener();
    }

}
