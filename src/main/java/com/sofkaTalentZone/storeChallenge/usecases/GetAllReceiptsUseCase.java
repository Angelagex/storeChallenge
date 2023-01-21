package com.sofkaTalentZone.storeChallenge.usecases;

import com.sofkaTalentZone.storeChallenge.mapper.ReceiptMapper;
import com.sofkaTalentZone.storeChallenge.model.ReceiptDTO;
import com.sofkaTalentZone.storeChallenge.repository.IReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllReceiptsUseCase {

    private ReceiptMapper receiptMapper;
    private IReceiptRepository receiptRepository;



    public Flux<ReceiptDTO> getAllReceipt() {
        return receiptRepository.findAll().map(receipt -> receiptMapper.convertEntityToDTO().apply(receipt));
    }
}