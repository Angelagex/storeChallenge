package com.sofkaTalentZone.storeChallenge.usecases;

import com.sofkaTalentZone.storeChallenge.repository.IBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteBillUseCase {

    private IBillRepository billRepository;


    public Mono<Void> deleteById(String id) {
        return billRepository.findById(id).flatMap( result -> billRepository.deleteById(result.getId()));
    }
}