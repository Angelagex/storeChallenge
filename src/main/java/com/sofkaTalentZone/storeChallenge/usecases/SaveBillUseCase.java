package com.sofkaTalentZone.storeChallenge.usecases;

import com.sofkaTalentZone.storeChallenge.mapper.BillMapper;
import com.sofkaTalentZone.storeChallenge.mapper.ProductMapper;
import com.sofkaTalentZone.storeChallenge.model.BillDTO;
import com.sofkaTalentZone.storeChallenge.repository.IBillRepository;
import com.sofkaTalentZone.storeChallenge.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class SaveBillUseCase {

    private BillMapper billMapper;
    private ProductMapper productMapper;
    private IBillRepository billRepository;
    private IProductRepository productRepository;


    public Mono<BillDTO> saveBill(BillDTO dto) {

        return billRepository.save(billMapper.convertDTOToEntity().apply(dto))
                .map( bill -> billMapper.convertEntityToDTO().apply(bill));
    }
}