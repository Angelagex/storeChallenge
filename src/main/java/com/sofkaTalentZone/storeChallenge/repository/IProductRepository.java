package com.sofkaTalentZone.storeChallenge.repository;

import com.sofkaTalentZone.storeChallenge.collection.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
}
