package com.tss.advancedmappingapp.controller;

import com.tss.advancedmappingapp.dto.request.InstructorRequestDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.InstructorResponseDto;
import com.tss.advancedmappingapp.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentapp")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    // CREATE instructor
    @PostMapping("/instructor")
    public ResponseEntity<InstructorResponseDto> addInstructor(@RequestBody InstructorRequestDto instructorRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(instructorService.addInstructor(instructorRequestDto));
    }

    // GET all instructors
    @GetMapping("/instructor")
    public ResponseEntity<List<InstructorResponseDto>> getAllInstructors(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(instructorService.getAllInstructors());
    }

    // GET instructor by ID
    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<InstructorResponseDto> getInstructorById(@PathVariable("instructorId") Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(instructorService.getInstructorById(id));
    }

    // UPDATE instructor
    @PutMapping("/instructor/{instructorId}")
    public ResponseEntity<InstructorResponseDto> updateInstructor(
            @PathVariable("instructorId") Long id,
            @RequestBody InstructorRequestDto instructorRequestDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(instructorService.updateInstructor(id, instructorRequestDto));
    }

    // DELETE instructor
    @DeleteMapping("/instructor/{instructorId}")
    public ResponseEntity<Void> deleteInstructorById(@PathVariable("instructorId") Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // ASSIGN course to instructor
    @PutMapping("/instructor/{instructorId}/courses/{courseId}")
    public ResponseEntity<CourseResponseDto> assignCourseToInstructor(
            @PathVariable("instructorId") Long instructorId,
            @PathVariable("courseId") Long courseId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(instructorService.assignCourseToInstructor(instructorId, courseId));
    }

    @GetMapping("/instructor/search")
    public ResponseEntity<List<InstructorResponseDto>> getInstructorsByPrefix(
            @RequestParam String prefix) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(instructorService.getInstructorsByNamePrefix(prefix));
    }
}