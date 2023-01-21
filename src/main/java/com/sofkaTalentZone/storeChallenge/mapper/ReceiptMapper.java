package com.sofkaTalentZone.storeChallenge.mapper;

import com.sofkaTalentZone.storeChallenge.collection.Receipt;
import com.sofkaTalentZone.storeChallenge.model.ReceiptDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ReceiptMapper {

    private ModelMapper modelMapper;

    public ReceiptMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Function<Receipt, ReceiptDTO> convertEntityToDTO(){
        return product ->
                modelMapper.map(product, ReceiptDTO.class);
    }

    public Function<ReceiptDTO, Receipt> convertDTOToEntity (){
        return productDTO ->
                modelMapper.map(productDTO,Receipt.class);
    }
}
