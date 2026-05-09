package com.tss.advancedmappingapp.service;

import com.tss.advancedmappingapp.dto.request.AddressRequestDto;
import com.tss.advancedmappingapp.dto.request.StudentRequestDto;
import com.tss.advancedmappingapp.dto.response.AddressResponseDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentService {
    StudentResponseDto addNewStudent(StudentRequestDto studentRequestDto);

    List<StudentResponseDto> readAllStudents();

    StudentResponseDto updateStudentAddress(Long id, AddressRequestDto addressRequestDto);

    AddressResponseDto getStudentAddress(Long id);

    StudentResponseDto assignCourseToStudent(Long studentId, Long courseId);

    List<CourseResponseDto> getCoursesByStudent(Long studentId);

    void updateStudentCourse(Long studentId, Long oldCourseId, Long newCourseId);
}
