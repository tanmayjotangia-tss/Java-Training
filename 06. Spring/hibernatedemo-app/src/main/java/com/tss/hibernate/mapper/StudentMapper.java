package com.tss.hibernate.mapper;

import com.tss.hibernate.dto.request.StudentRequestDTO;
import com.tss.hibernate.dto.response.StudentResponseDTO;
import com.tss.hibernate.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequestDTO dto);
    StudentResponseDTO toDTO(Student student);
}
