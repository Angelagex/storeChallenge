package com.sofkaTalentZone.storeChallenge.usecases;
import com.sofkaTalentZone.storeChallenge.mapper.ReceiptMapper;
import com.sofkaTalentZone.storeChallenge.model.ReceiptDTO;
import com.sofkaTalentZone.storeChallenge.repository.IReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class SaveReceiptUseCase {

    private ReceiptMapper receiptMapper;
    private IReceiptRepository receiptRepository;


    public Mono<ReceiptDTO>
    saveReceipt(ReceiptDTO dto) {


        return receiptRepository.save(receiptMapper.convertDTOToEntity().apply(dto))
                .map( receipt -> receiptMapper.convertEntityToDTO().apply(receipt));
    }
}