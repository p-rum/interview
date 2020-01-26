package cz.exampleproject.mediagroup.hw.gpcparser;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import cz.exampleproject.mediagroup.hw.gpcparser.config.AppConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoClientFactory;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableConfigurationProperties
@Import({AppConfigProperties.class})
@EnableMongoRepositories
@EnableMongoAuditing
public class AppConfiguration {

	@Autowired
	Environment environment;

	@Bean
	MongoAutoConfiguration autoConfiguration ( ) {
		return new MongoAutoConfiguration();
	}

	@Bean
	MongoClient mongoClient ( ) {
		return new MongoClientFactory(new MongoProperties(), environment).createMongoClient(
				MongoClientOptions.builder().build()
		);
	}
}
