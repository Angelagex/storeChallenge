package com.sofkaTalentZone.storeChallenge.mapper;

import com.sofkaTalentZone.storeChallenge.collection.Bill;
import com.sofkaTalentZone.storeChallenge.model.BillDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BillMapper {

    private ModelMapper modelMapper;

    public BillMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Function<Bill, BillDTO> convertEntityToDTO(){
        return product ->
                modelMapper.map(product, BillDTO.class);
    }

    public Function<BillDTO, Bill> convertDTOToEntity (){
        return productDTO ->
                modelMapper.map(productDTO,Bill.class);
    }
}