package com.sofkaTalentZone.storeChallenge.repository;

import com.sofkaTalentZone.storeChallenge.collection.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiptRepository extends ReactiveMongoRepository<Receipt, String> {
}