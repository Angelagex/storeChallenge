package com.sofkaTalentZone.storeChallenge.usecases;

import com.sofkaTalentZone.storeChallenge.mapper.ProductMapper;
import com.sofkaTalentZone.storeChallenge.model.ProductDTO;
import com.sofkaTalentZone.storeChallenge.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProductsUseCase {

    private ProductMapper productMapper;
    private IProductRepository productRepository;



    public Flux<ProductDTO> getAllProduct() {
        return productRepository.findAll().map(product -> productMapper.convertEntityToDTO().apply(product));
    }
}