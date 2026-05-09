package com.tss.hibernate.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class StudentResponseDTO {
    private int id;
    private String name;
}
