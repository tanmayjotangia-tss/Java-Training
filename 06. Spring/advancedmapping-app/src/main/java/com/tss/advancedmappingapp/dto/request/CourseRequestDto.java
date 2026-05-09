package com.tss.advancedmappingapp.dto.request;

import lombok.Data;

@Data
public class CourseRequestDto {

    private String courseName;
    private Integer duration;
    private Double courseFees;

    // Link to instructor
    private Long instructorId;
}
