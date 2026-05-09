package com.tss.advancedmappingapp.dto.response;

import lombok.Data;

@Data
public class CourseResponseDto {

    private Long courseId;
    private String courseName;
    private Integer duration;
    private Double courseFees;

    // Keep instructor minimal to avoid recursion
    private InstructorSummaryDto instructor;
}
