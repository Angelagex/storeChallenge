package com.sofkaTalentZone.storeChallenge.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories
public class MongoDBConf {

    @Bean
    public MongoClient mongoDBClientProd (Environment env) {
        val uri = env.getProperty("spring.data.mongodb.uri");
        val mongoSettings =  MongoClientSettings.builder().applyConnectionString(new ConnectionString(uri)).build();
        return MongoClients.create(mongoSettings);
    }

    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoDBClient) {
        return new ReactiveMongoTemplate(mongoDBClient, "storechallenge");
    }
}
