package com.tss.advancedmappingapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDto {

    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotNull
    private Integer pincode;
}
