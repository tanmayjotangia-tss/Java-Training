package com.tss.advancedmappingapp.service;

import com.tss.advancedmappingapp.dto.request.InstructorRequestDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.InstructorResponseDto;

import java.util.List;

public interface InstructorService {
    InstructorResponseDto addInstructor(InstructorRequestDto instructorRequestDto);
    List<InstructorResponseDto> getAllInstructors();
    InstructorResponseDto getInstructorById(Long id);
    CourseResponseDto assignCourseToInstructor(Long instructorId, Long courseId);
    InstructorResponseDto updateInstructor(Long id, InstructorRequestDto dto);
    void deleteInstructor(Long id);
    List<InstructorResponseDto> getInstructorsByNamePrefix(String prefix);
}
