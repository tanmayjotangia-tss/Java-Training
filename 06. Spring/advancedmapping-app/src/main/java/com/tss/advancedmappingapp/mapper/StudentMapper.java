package com.tss.advancedmappingapp.mapper;

import com.tss.advancedmappingapp.dto.request.StudentRequestDto;
import com.tss.advancedmappingapp.dto.response.StudentResponseDto;
import com.tss.advancedmappingapp.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface StudentMapper {

    @Mapping(source = "address", target = "addressResponseDto")
    StudentResponseDto toDTO(Student student);

    @Mapping(source = "addressRequestDto", target = "address")
    Student toEntity(StudentRequestDto dto);
}