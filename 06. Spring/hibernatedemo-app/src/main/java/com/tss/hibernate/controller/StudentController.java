package com.tss.hibernate.controller;

import com.tss.hibernate.dto.page.StudentPageResponseDTO;
import com.tss.hibernate.dto.request.StudentRequestDTO;
import com.tss.hibernate.dto.response.StudentResponseDTO;
import com.tss.hibernate.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/studentapp")
public class StudentController {

    private final StudentService studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<StudentPageResponseDTO> getAllStudents(
            @RequestParam(required = false) String name,
            @RequestParam Integer pageSize,
            @RequestParam Integer pageNumber) {

        if (name == null) {
            return ResponseEntity.ok(studentService.findAll(pageSize, pageNumber));
        }

        logger.info("Called Get API on: /studentapp/students");
        return ResponseEntity.ok(studentService.getByName(name, pageSize, pageNumber));
    }

//    @PostMapping("/students")
//    public ResponseEntity<Student> addStudent(@RequestBody Student student) {a

    /// /        return ResponseEntity.ok(studentService.addStudent(student));
    /// /        return ResponseEntity.noContent().build();
//        return new ResponseEntity<>(student, HttpStatus.CREATED);
//    }
    @PostMapping("/students")
    public ResponseEntity<StudentResponseDTO> addStudent(@Valid @RequestBody StudentRequestDTO student) {
        logger.info("Called POST API on /studentapp/students");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.addStudent(student));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> findStudentById(@PathVariable int id) {
        logger.info("Called Get API on: /studentapp/students/" + id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.findStudentById(id));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable int id, @Valid @RequestBody StudentRequestDTO studentDTO) {
        logger.info("Called PATCH API on: /studentapp/students/" + id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.updateStudent(id, studentDTO));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable int id) {
        studentService.deleteStudent(id);
        logger.info("Called DELETE API on /studentapp/students/" + id);
        return ResponseEntity.noContent().build();
    }


}
