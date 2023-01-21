package com.sofkaTalentZone.storeChallenge.usecases;

import com.sofkaTalentZone.storeChallenge.mapper.BillMapper;
import com.sofkaTalentZone.storeChallenge.model.BillDTO;
import com.sofkaTalentZone.storeChallenge.repository.IBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllBillsUseCase {

    private BillMapper billMapper;
    private IBillRepository billRepository;



    public Flux<BillDTO> getAllBill() {
        return billRepository.findAll().map(bill -> billMapper.convertEntityToDTO().apply(bill));
    }
}
