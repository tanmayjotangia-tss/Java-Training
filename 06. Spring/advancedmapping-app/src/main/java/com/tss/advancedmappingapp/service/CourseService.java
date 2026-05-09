package com.tss.advancedmappingapp.service;

import com.tss.advancedmappingapp.dto.request.CourseRequestDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.InstructorResponseDto;
import com.tss.advancedmappingapp.dto.response.StudentResponseDto;
import com.tss.advancedmappingapp.entity.Course;
import com.tss.advancedmappingapp.entity.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseResponseDto addCourse(CourseRequestDto courseResponseDto);
    CourseResponseDto assignInstructor(Long courseId, Long instructorId);
    CourseResponseDto removeInstructor(Long courseId);
    List<CourseResponseDto> getAllCourses();
    CourseResponseDto getCourseById(Long id);
    List<CourseResponseDto> getCoursesWithNoInstructor();
    List<CourseResponseDto> getCoursesByInstructorId(Long instructorId);
    InstructorResponseDto getInstructorByCourse(Long courseId);
    CourseResponseDto updateCourse(Long id, CourseRequestDto courseRequestDto);
    void deleteCourse(Long id);
    long getCourseCount();
    long getCourseCountByInstructor(Long instructorId);
    List<StudentResponseDto> getStudentsByCourse(Long courseId);
}