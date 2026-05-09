package com.tss.advancedmappingapp.service;

import com.tss.advancedmappingapp.dto.request.InstructorRequestDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.InstructorResponseDto;
import com.tss.advancedmappingapp.entity.Course;
import com.tss.advancedmappingapp.entity.Instructor;
import com.tss.advancedmappingapp.exception.ResourceNotFoundException;
import com.tss.advancedmappingapp.mapper.CourseMapper;
import com.tss.advancedmappingapp.mapper.InstructorMapper;
import com.tss.advancedmappingapp.repository.CourseRepository;
import com.tss.advancedmappingapp.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImplementation implements InstructorService{
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final InstructorMapper instructorMapper;
    private final CourseMapper courseMapper;

    @Override
    public InstructorResponseDto addInstructor(InstructorRequestDto instructorRequestDto) {

        // DTO → Entity
        Instructor instructor = instructorMapper.toEntity(instructorRequestDto);

        // Save to DB
        Instructor savedInstructor = instructorRepository.save(instructor);

        // Entity → Summary DTO
        InstructorResponseDto response = new InstructorResponseDto();
        response.setInstructorId(savedInstructor.getInstructorId());
        response.setName(savedInstructor.getName());

        return response;
    }

    @Override
    public List<InstructorResponseDto> getAllInstructors() {
        return instructorRepository.findAll()
                .stream()
                .map(instructorMapper::toDTO)
                .toList();
    }

    @Override
    public InstructorResponseDto getInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        return instructorMapper.toDTO(instructor);
    }

    @Override
    public CourseResponseDto assignCourseToInstructor(Long instructorId, Long courseId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setInstructor(instructor);

        return courseMapper.toDTO(courseRepository.save(course));
    }

    @Override
    public InstructorResponseDto updateInstructor(Long id, InstructorRequestDto dto) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        instructor.setName(dto.getName());
        instructor.setQualification(dto.getQualification());

        return instructorMapper.toDTO(instructorRepository.save(instructor));
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public List<InstructorResponseDto> getInstructorsByNamePrefix(String prefix) {
        List<Instructor> instructors = instructorRepository
                .findByNameStartingWithIgnoreCase(prefix);

        if (instructors.isEmpty()) {
            throw new ResourceNotFoundException("Instructors",prefix);
        }

        return instructors.stream()
                .map(instructorMapper::toDTO)
                .toList();
    }
}
