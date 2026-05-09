package com.tss.advancedmappingapp.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class InstructorRequestDto {

    private String name;
    private String qualification;

    // Optional: assign existing courses by IDs
//    private List<Long> courseIds;
}