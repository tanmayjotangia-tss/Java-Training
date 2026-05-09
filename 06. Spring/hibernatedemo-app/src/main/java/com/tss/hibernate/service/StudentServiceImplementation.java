package com.tss.hibernate.service;

import com.tss.hibernate.dto.page.StudentPageResponseDTO;
import com.tss.hibernate.dto.request.StudentRequestDTO;
import com.tss.hibernate.dto.response.StudentResponseDTO;
import com.tss.hibernate.entity.Student;
import com.tss.hibernate.exception.ApplicationException;
import com.tss.hibernate.exception.ResourceNotFound;
import com.tss.hibernate.mapper.StudentMapper;
import com.tss.hibernate.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepo;
    private final StudentMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImplementation.class);

    @Override
    public StudentPageResponseDTO findAll(Integer pageSize, Integer pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Student> page = studentRepo.findAll(pageable);

        List<StudentResponseDTO> content = page.getContent()
                .stream()
                .map(mapper::toDTO)
                .toList();

        logger.info("All students fetched");
        return new StudentPageResponseDTO(
                content,
                page.getNumberOfElements(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );

//        return studentRepo.findAll(pageable)
//                .map(mapper::toDTO);
    }

    @Override
    public StudentPageResponseDTO getByName(String name, Integer pageSize, Integer pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Student> page = studentRepo.findByName(name,pageable);

        List<StudentResponseDTO> content = page.getContent()
                .stream()
                .map(mapper::toDTO)
                .toList();

        logger.info("Student found by name: " + name);
        return new StudentPageResponseDTO(
                content,
                page.getNumberOfElements(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast());

//        return studentRepo.findByName(name, pageable)
//                .map(mapper::toDTO);
    }

    @Override
    public StudentResponseDTO addStudent(StudentRequestDTO studentDTO){
        Student student = mapper.toEntity(studentDTO);
        Student savedStudent = studentRepo.save(student);
        logger.info("Student added by name: " + studentDTO.getName());
        return mapper.toDTO(savedStudent);
    }

    @Override
    public void deleteStudent(int id) {
        if (!studentRepo.existsById(id)) {
            throw new RuntimeException("Student not found for the id: " + id);
        }
        logger.info("Student deleted with student id: " + id);
        studentRepo.deleteById(id);
    }

    @Override
    public StudentResponseDTO updateStudent(int id, StudentRequestDTO studentRequestDTO) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for the id: " + id));
        existingStudent.setName(studentRequestDTO.getName());
        existingStudent.setAge(studentRequestDTO.getAge());

        Student updatedStudent = studentRepo.save(existingStudent);
        logger.info("Student info updated for the id: " + id);
        return mapper.toDTO(updatedStudent);
    }

    @Override
    public StudentResponseDTO findStudentById(int id) {
        logger.info("Student found for id: " + id);
        return studentRepo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFound("Student",id) {
                });
    }
}
