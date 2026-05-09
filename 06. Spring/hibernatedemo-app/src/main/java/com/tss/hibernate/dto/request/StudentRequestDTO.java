package com.tss.hibernate.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class StudentRequestDTO {
    @NotBlank
    @Size(min = 4, max=20)
    private String name;
    @NotNull
    @Min(value=1,message = "Age can not be less than 1")
    private int age;
}
