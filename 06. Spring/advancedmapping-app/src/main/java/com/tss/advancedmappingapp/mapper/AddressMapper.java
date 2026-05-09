package com.tss.advancedmappingapp.mapper;

import com.tss.advancedmappingapp.dto.request.AddressRequestDto;
import com.tss.advancedmappingapp.dto.response.AddressResponseDto;
import com.tss.advancedmappingapp.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressRequestDto dto);
    AddressResponseDto toDTO(Address address);
}
