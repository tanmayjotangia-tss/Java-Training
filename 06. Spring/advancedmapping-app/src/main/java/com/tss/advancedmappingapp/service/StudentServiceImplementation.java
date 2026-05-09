package com.tss.advancedmappingapp.service;

import com.tss.advancedmappingapp.dto.request.AddressRequestDto;
import com.tss.advancedmappingapp.dto.request.StudentRequestDto;
import com.tss.advancedmappingapp.dto.response.AddressResponseDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.StudentResponseDto;
import com.tss.advancedmappingapp.entity.Address;
import com.tss.advancedmappingapp.entity.Course;
import com.tss.advancedmappingapp.entity.Student;
import com.tss.advancedmappingapp.exception.ResourceNotFoundException;
import com.tss.advancedmappingapp.mapper.AddressMapper;
import com.tss.advancedmappingapp.mapper.CourseMapper;
import com.tss.advancedmappingapp.mapper.StudentMapper;
import com.tss.advancedmappingapp.repository.CourseRepository;
import com.tss.advancedmappingapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService{
    private final StudentMapper studentMapper;
    private final AddressMapper addressMapper;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public StudentResponseDto addNewStudent(StudentRequestDto dto) {
        Student student = studentMapper.toEntity(dto);

        if (student.getAddress() != null) {
            student.getAddress().setStudent(student);
        }

        Student saved = studentRepository.save(student);
        log.info("Student inserted for student name : {}",dto.getName());
        return studentMapper.toDTO(saved);
    }

    @Override
    public List<StudentResponseDto> readAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .toList();
    }

    @Override
    public StudentResponseDto updateStudentAddress(Long id, AddressRequestDto addressRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student",id));

        Address address = student.getAddress();

        if (address == null) {
            address = addressMapper.toEntity(addressRequestDto);
            address.setStudent(student);
            student.setAddress(address);
        } else {
            address.setCity(addressRequestDto.getCity());
            address.setState(addressRequestDto.getState());
            address.setPincode(addressRequestDto.getPincode());
        }

        Student updatedStudent = studentRepository.save(student);
        log.info("Address updated for student id : {}",id);
        return studentMapper.toDTO(updatedStudent);
    }

    @Override
    public AddressResponseDto getStudentAddress(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student",id));

        Address address = student.getAddress();
        if (address == null) {
            throw new ResourceNotFoundException("Address",student);
        }

        log.info("Fetched address for student id : {}",id);
        return addressMapper.toDTO(address);
    }

    @Override
    public StudentResponseDto assignCourseToStudent(Long studentId, Long courseId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));


        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);

        return studentMapper.toDTO(student);
    }

    @Override
    public List<CourseResponseDto> getCoursesByStudent(Long studentId) {
        Student student = studentRepository.findByIdWithCourses(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return student.getCourses()
                .stream()
                .map(courseMapper::toDTO)
                .toList();
    }

    @Override
    public void updateStudentCourse(Long studentId, Long oldCourseId, Long newCourseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course oldCourse = courseRepository.findById(oldCourseId)
                .orElseThrow(() -> new RuntimeException("Old course not found"));

        Course newCourse = courseRepository.findById(newCourseId)
                .orElseThrow(() -> new RuntimeException("New course not found"));

        student.getCourses().remove(oldCourse);
        oldCourse.getStudents().remove(student);
        student.getCourses().add(newCourse);
        newCourse.getStudents().add(student);

        studentRepository.save(student);
    }
}