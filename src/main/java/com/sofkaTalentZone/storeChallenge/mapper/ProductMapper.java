package com.sofkaTalentZone.storeChallenge.mapper;

import com.sofkaTalentZone.storeChallenge.collection.Product;
import com.sofkaTalentZone.storeChallenge.model.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductMapper {

    private ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Function<Product, ProductDTO> convertEntityToDTO(){
        return product ->
                modelMapper.map(product, ProductDTO.class);
    }

    public Function<ProductDTO, Product> convertDTOToEntity (){
        return productDTO ->
                modelMapper.map(productDTO,Product.class);
    }
}