package com.tss.advancedmappingapp.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class InstructorResponseDto {

    private Long instructorId;
    private String name;
    private String qualification;

    // Nested course details (lightweight)
    private List<CourseResponseDto> courses;
}
