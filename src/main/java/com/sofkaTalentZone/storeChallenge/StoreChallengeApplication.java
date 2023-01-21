package com.sofkaTalentZone.storeChallenge;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@ComponentScan(basePackages = "com.sofkaTalentZone.storeChallenge.repository")
@OpenAPIDefinition(info = @Info(title = "Store Challenge API", version = "1.0", description = "API Documentation v1.0"))
public class StoreChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreChallengeApplication.class, args);
	}

}
