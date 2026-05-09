package com.tss.advancedmappingapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto {
    @NotNull
    private Long rollNumber;
    @NotBlank
    private String name;
    @NotNull
    private AddressRequestDto addressRequestDto;
}
