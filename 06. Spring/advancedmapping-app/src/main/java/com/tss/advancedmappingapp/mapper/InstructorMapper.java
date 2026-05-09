package com.tss.advancedmappingapp.mapper;

import com.tss.advancedmappingapp.dto.request.InstructorRequestDto;
import com.tss.advancedmappingapp.dto.response.InstructorResponseDto;
import com.tss.advancedmappingapp.entity.Instructor;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface InstructorMapper {

    InstructorResponseDto toDTO(Instructor instructor);

    Instructor toEntity(InstructorRequestDto dto);
}