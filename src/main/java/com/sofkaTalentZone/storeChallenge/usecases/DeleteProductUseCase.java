package com.sofkaTalentZone.storeChallenge.usecases;

import com.sofkaTalentZone.storeChallenge.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteProductUseCase {

    private IProductRepository productRepository;


    public Mono<Void> deleteById(String id) {
        return productRepository.findById(id).flatMap( result -> productRepository.deleteById(result.getId()));
    }
}
