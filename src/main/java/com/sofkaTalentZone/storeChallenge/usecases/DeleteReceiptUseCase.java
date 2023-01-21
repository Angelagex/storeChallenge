package com.sofkaTalentZone.storeChallenge.usecases;

import com.sofkaTalentZone.storeChallenge.repository.IReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteReceiptUseCase {

    private IReceiptRepository receiptRepository;


    public Mono<Void> deleteById(String id) {
        return receiptRepository.findById(id).flatMap( result -> receiptRepository.deleteById(result.getId()));
    }
}