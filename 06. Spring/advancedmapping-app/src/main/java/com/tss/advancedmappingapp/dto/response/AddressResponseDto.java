package com.tss.advancedmappingapp.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Setter
@RequiredArgsConstructor
public class AddressResponseDto {

    @NotBlank
    private final String city;
    @NotBlank
    private final String state;
    @NotNull
    private final Integer pincode;
}