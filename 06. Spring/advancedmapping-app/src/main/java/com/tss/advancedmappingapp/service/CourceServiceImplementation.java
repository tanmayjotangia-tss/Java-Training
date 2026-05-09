package com.tss.advancedmappingapp.service;

import com.tss.advancedmappingapp.dto.request.CourseRequestDto;
import com.tss.advancedmappingapp.dto.response.CourseResponseDto;
import com.tss.advancedmappingapp.dto.response.InstructorResponseDto;
import com.tss.advancedmappingapp.dto.response.StudentResponseDto;
import com.tss.advancedmappingapp.entity.Course;
import com.tss.advancedmappingapp.entity.Instructor;
import com.tss.advancedmappingapp.mapper.CourseMapper;
import com.tss.advancedmappingapp.mapper.InstructorMapper;
import com.tss.advancedmappingapp.mapper.StudentMapper;
import com.tss.advancedmappingapp.repository.CourseRepository;
import com.tss.advancedmappingapp.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourceServiceImplementation implements CourseService{
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final CourseMapper courseMapper;
    private final InstructorMapper instructorMapper;
    private final StudentMapper studentMapper;

    @Override
    public CourseResponseDto addCourse(CourseRequestDto courseRequestDto) {

        Course course = courseMapper.toEntity(courseRequestDto);

        if (courseRequestDto.getInstructorId() != null) {
            Instructor instructor = instructorRepository.findById(courseRequestDto.getInstructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor not found"));

            course.setInstructor(instructor);
        }

        Course savedCourse = courseRepository.save(course);

        return courseMapper.toDTO(savedCourse);
    }

    @Override
    public CourseResponseDto assignInstructor(Long courseId, Long instructorId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        course.setInstructor(instructor);

        Course updatedCourse = courseRepository.save(course);

        return courseMapper.toDTO(updatedCourse);
    }

    @Override
    public CourseResponseDto removeInstructor(Long courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setInstructor(null);
        Course updatedCourse = courseRepository.save(course);
        return courseMapper.toDTO(updatedCourse);
    }

    @Override
    public List<CourseResponseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .toList();
    }

    @Override
    public CourseResponseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return courseMapper.toDTO(course);
    }

    @Override
    public List<CourseResponseDto> getCoursesWithNoInstructor() {

        return courseRepository.findAll()
                .stream()
                .filter(course -> course.getInstructor() == null)
                .map(courseMapper::toDTO)
                .toList();
    }

    @Override
    public List<CourseResponseDto> getCoursesByInstructorId(Long instructorId) {
        return courseRepository.findCoursesWithInstructor(instructorId)
                .stream()
                .map(courseMapper::toDTO)
                .toList();
    }

    @Override
    public InstructorResponseDto getInstructorByCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (course.getInstructor() == null) {
            throw new RuntimeException("No instructor assigned to this course");
        }

        Instructor instructor = course.getInstructor();

        return instructorMapper.toDTO(instructor);
    }

    @Override
    public CourseResponseDto updateCourse(Long id, CourseRequestDto courseRequestDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setCourseName(courseRequestDto.getCourseName());
        course.setDuration(courseRequestDto.getDuration());
        course.setCourseFees(course.getCourseFees());

        return courseMapper.toDTO(courseRepository.save(course));
    }


    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public long getCourseCount() {
        return courseRepository.count();
    }

    @Override
    public long getCourseCountByInstructor(Long instructorId) {
        return courseRepository.countByInstructorInstructorId(instructorId);
    }

    @Override
    public List<StudentResponseDto> getStudentsByCourse(Long courseId) {
        Course course = courseRepository.findByIdWithStudents(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return course.getStudents()
                .stream()
                .map(studentMapper :: toDTO)
                .toList();
    }
}