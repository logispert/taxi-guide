package taxiguider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import taxiguider.TaxicallRepositoryListener;

@Configuration
@EnableMongoAuditing
public class TaxicallAppConfig {
	@Bean
    public TaxicallRepositoryListener TaxicallRepositoryListener() {
        return new TaxicallRepositoryListener();
    }

}
