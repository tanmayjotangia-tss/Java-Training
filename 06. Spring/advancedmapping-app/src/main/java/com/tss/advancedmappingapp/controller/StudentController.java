package com.tss.advancedmappingapp.controller;

import com.tss.advancedmappingapp.dto.request.AddressRequestDto;
import com.tss.advancedmappingapp.dto.request.StudentRequestDto;
import com.tss.advancedmappingapp.dto.response.AddressResponseDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.StudentResponseDto;
import com.tss.advancedmappingapp.entity.Student;
import com.tss.advancedmappingapp.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Validated
@RestController
@RequestMapping("/studentapp")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<StudentResponseDto> addNewStudent(@Valid @RequestBody StudentRequestDto studentRequestDto){
        log.info("POST /studentapp/students called for student: {}", studentRequestDto.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.addNewStudent(studentRequestDto));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        log.info("GET /studentapp/students called");
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.readAllStudents());
    }

    @PutMapping("/students/{id}/address")
    public ResponseEntity<StudentResponseDto> updateAddress(
            @PathVariable Long id,
            @Valid @RequestBody AddressRequestDto addressRequestDto) {
        log.info("PUT /studentapp/students/{}/address called for student: {}", id,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(studentService.updateStudentAddress(id, addressRequestDto));
    }

    @GetMapping("/students/{id}/address")
    public ResponseEntity<AddressResponseDto> getStudentAddress(@PathVariable Long id) {
        log.info("GET /studentapp/students/{}/address called for student: {}", id,id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getStudentAddress(id));
    }

    @PutMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<StudentResponseDto> assignCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.assignCourseToStudent(studentId, courseId));
    }

    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity<List<CourseResponseDto>> getCourses(
            @PathVariable Long studentId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getCoursesByStudent(studentId));
    }

    @PutMapping("/students/{studentId}/update/oldCourse/{oldCourseId}/newCourse/{newCourseId}")
    public ResponseEntity<Void> updateCourse(@PathVariable Long studentId,
                                             @PathVariable Long oldCourseId,
                                             @PathVariable Long newCourseId) {
        studentService.updateStudentCourse(studentId, oldCourseId, newCourseId);
        return ResponseEntity.ok().build();
    }
}