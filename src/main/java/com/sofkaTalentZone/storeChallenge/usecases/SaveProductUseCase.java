package com.sofkaTalentZone.storeChallenge.usecases;

import com.sofkaTalentZone.storeChallenge.mapper.ProductMapper;
import com.sofkaTalentZone.storeChallenge.model.ProductDTO;
import com.sofkaTalentZone.storeChallenge.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class SaveProductUseCase {

    private ProductMapper productMapper;
    private IProductRepository productRepository;


    public Mono<ProductDTO> saveProduct(ProductDTO dto) {
        return productRepository.save(productMapper.convertDTOToEntity().apply(dto))
                .map( product -> productMapper.convertEntityToDTO().apply(product));
    }
}
