package com.tss.advancedmappingapp.mapper;

import com.tss.advancedmappingapp.dto.request.CourseRequestDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.InstructorResponseDto;
import com.tss.advancedmappingapp.dto.response.InstructorSummaryDto;
import com.tss.advancedmappingapp.entity.Course;
import com.tss.advancedmappingapp.entity.Instructor;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "instructor", target = "instructor")
    CourseResponseDto toDTO(Course course);

    @Mapping(source = "instructorId", target = "instructor.instructorId")
    Course toEntity(CourseRequestDto dto);

//    // Instructor → Summary DTO
    default InstructorSummaryDto toSummary(Instructor instructor) {
        if (instructor == null) return null;

        InstructorSummaryDto dto = new InstructorSummaryDto();
        dto.setInstructorId(instructor.getInstructorId());
        dto.setName(instructor.getName());
        return dto;
    }

}