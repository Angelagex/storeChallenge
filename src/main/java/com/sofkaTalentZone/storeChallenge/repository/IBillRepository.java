package com.sofkaTalentZone.storeChallenge.repository;

import com.sofkaTalentZone.storeChallenge.collection.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@Repository
public interface IBillRepository extends ReactiveMongoRepository<Bill, String> {
}
