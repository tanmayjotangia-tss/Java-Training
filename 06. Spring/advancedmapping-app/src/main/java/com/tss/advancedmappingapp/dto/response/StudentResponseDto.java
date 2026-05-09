package com.tss.advancedmappingapp.dto.response;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Setter
@RequiredArgsConstructor
public class StudentResponseDto {

    @NotNull
    private final Integer id;
    @NotNull
    private final Integer rollNumber;
    @NotBlank
    private final String name;
    @NotNull
    @Valid
    private final AddressResponseDto addressResponseDto;
}