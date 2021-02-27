package taxiguider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import taxiguider.TaxiCallRepositoryListener;

@Configuration
@EnableMongoAuditing
public class AppConfig {
	@Bean
    public TaxiCallRepositoryListener orderRepositoryListener() {
        return new TaxiCallRepositoryListener();
    }

}
