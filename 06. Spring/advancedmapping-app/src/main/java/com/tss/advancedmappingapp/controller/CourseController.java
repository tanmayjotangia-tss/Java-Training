package com.tss.advancedmappingapp.controller;

import com.tss.advancedmappingapp.dto.request.CourseRequestDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.InstructorResponseDto;
import com.tss.advancedmappingapp.dto.response.StudentResponseDto;
import com.tss.advancedmappingapp.entity.Course;
import com.tss.advancedmappingapp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studentapp")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    // CREATE a new course
    @PostMapping("/course")
    public ResponseEntity<CourseResponseDto> addCourse(@RequestBody CourseRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.addCourse(dto));
    }

    // ASSIGN an instructor to a course
    @PutMapping("/course/{courseId}/assign/{instructorId}")
    public ResponseEntity<CourseResponseDto> assignInstructor(
            @PathVariable("courseId") Long courseId,
            @PathVariable("instructorId") Long instructorId) {

        return ResponseEntity.ok(courseService.assignInstructor(courseId, instructorId));
    }

    // REMOVE instructor from a course
    @PutMapping("/course/{courseId}/remove")
    public ResponseEntity<CourseResponseDto> removeInstructor(@PathVariable("courseId") Long courseId) {
        return ResponseEntity.ok(courseService.removeInstructor(courseId));
    }

    // GET all courses
    @GetMapping("/course")
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // GET course by ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable("courseId") Long courseId) {
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    // GET all courses with no instructor assigned
    @GetMapping("/course/no-instructor")
    public ResponseEntity<List<CourseResponseDto>> getCoursesWithoutInstructor() {
        return ResponseEntity.ok(courseService.getCoursesWithNoInstructor());
    }

    // GET all courses by instructor ID
    @GetMapping("/course/with-instructor/{instructorId}")
    public ResponseEntity<List<CourseResponseDto>> getCoursesWithInstructor(
            @PathVariable("instructorId") Long instructorId) {

        return ResponseEntity.ok(courseService.getCoursesByInstructorId(instructorId));
    }

    // GET instructor of a specific course
    @GetMapping("/course/{courseId}/instructor")
    public ResponseEntity<InstructorResponseDto> getInstructorByCourse(@PathVariable("courseId") Long courseId) {
        return ResponseEntity.ok(courseService.getInstructorByCourse(courseId));
    }

    // UPDATE course by ID
    @PutMapping("/course/{courseId}")
    public ResponseEntity<CourseResponseDto> updateCourse(
            @PathVariable("courseId") Long courseId,
            @RequestBody CourseRequestDto dto) {

        return ResponseEntity.ok(courseService.updateCourse(courseId, dto));
    }

    // DELETE course by ID
    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/course/count/all")
    public ResponseEntity<Long> getCourseCount() {
        return ResponseEntity.ok(courseService.getCourseCount());
    }

    @GetMapping("/course/instructor/{instructorId}/count")
    public ResponseEntity<Long> getCourseCountByInstructor(
            @PathVariable Long instructorId) {

        return ResponseEntity.ok(
                courseService.getCourseCountByInstructor(instructorId)
        );
    }

    @GetMapping("/course/{courseId}/student")
    public ResponseEntity<List<StudentResponseDto>> getStudent(
            @PathVariable Long courseId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(courseService.getStudentsByCourse(courseId));
    }
}