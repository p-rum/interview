package cz.exampleproject.mediagroup.hw.gpcparser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import cz.exampleproject.mediagroup.hw.gpcparser.config.GPCConfigProperties;
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
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableConfigurationProperties
@Import({GPCConfigProperties.class})
@EnableMongoRepositories
@EnableMongoAuditing
@EnableWebMvc
public class AppConfiguration {

	@Autowired
	Environment environment;

	//not sure about mongo configurations, not working without it
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

	//Converter to/from json
	@Bean(name = "jacksonConverterBean")
	MappingJackson2HttpMessageConverter converter ( ) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(CollectionUtils.arrayToList(new MediaType[] {MediaType.ALL, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA}));
		converter.setObjectMapper(new ObjectMapper());
		return converter;
	}
}
