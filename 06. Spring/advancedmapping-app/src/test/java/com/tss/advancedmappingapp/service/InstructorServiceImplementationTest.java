package com.tss.advancedmappingapp.service;

import com.tss.advancedmappingapp.dto.request.InstructorRequestDto;
import com.tss.advancedmappingapp.dto.response.InstructorResponseDto;
import com.tss.advancedmappingapp.entity.Instructor;
import com.tss.advancedmappingapp.mapper.InstructorMapper;
import com.tss.advancedmappingapp.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstructorServiceImplementationTest{

    @Mock
    private InstructorRepository instructorRepository;

    @Mock
    private InstructorMapper instructorMapper;

    @InjectMocks
    private InstructorServiceImplementation instructorService;



    @Test
    void addInstructor() {
        InstructorRequestDto request = new InstructorRequestDto();
        request.setName("John");

        Instructor instructor = new Instructor();
        instructor.setName("John");

        Instructor savedInstructor = new Instructor();
        savedInstructor.setInstructorId(1L);
        savedInstructor.setName("John");

        when(instructorMapper.toEntity(request)).thenReturn(instructor);
        when(instructorRepository.save(instructor)).thenReturn(savedInstructor);

        InstructorResponseDto result = instructorService.addInstructor(request);

        assertNotNull(result);
        assertEquals(1L, result.getInstructorId());
        assertEquals("John", result.getName());
    }

    @Test
    void getAllInstructors() {
        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);
        instructor.setName("John");

        InstructorResponseDto dto = new InstructorResponseDto();
        dto.setInstructorId(1L);
        dto.setName("John");

        when(instructorRepository.findAll()).thenReturn(List.of(instructor));
        when(instructorMapper.toDTO(instructor)).thenReturn(dto);

        List<InstructorResponseDto> result = instructorService.getAllInstructors();

        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());    }

    @Test
    void getInstructorById() {
        Instructor instructor1 = new Instructor();
        instructor1.setInstructorId(1L);
        instructor1.setName("John");

        Instructor instructor2 = new Instructor();
        instructor2.setInstructorId(2L);
        instructor2.setName("Rahul");

        InstructorResponseDto dto1 = new InstructorResponseDto();
        dto1.setInstructorId(1L);
        dto1.setName("John");

        InstructorResponseDto dto2 = new InstructorResponseDto();
        dto2.setInstructorId(2L);
        dto2.setName("Rahul");

        when(instructorRepository.findById(1L)).thenReturn(Optional.of(instructor1));
        when(instructorMapper.toDTO(instructor1)).thenReturn(dto1);

        when(instructorRepository.findById(2L)).thenReturn(Optional.of(instructor2));
        when(instructorMapper.toDTO(instructor2)).thenReturn(dto2);

        InstructorResponseDto result1 = instructorService.getInstructorById(1L);
        InstructorResponseDto result2 = instructorService.getInstructorById(2L);

        assertEquals("John", result1.getName());
        assertEquals("Rahul", result2.getName());
    }

    @Test
    void assignCourseToInstructor() {
    }

    @Test
    void updateInstructor() {
        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);
        instructor.setName("Old");

        InstructorRequestDto request = new InstructorRequestDto();
        request.setName("New");
        request.setQualification("PhD");

        Instructor updated = new Instructor();
        updated.setInstructorId(1L);
        updated.setName("New");
        updated.setQualification("PhD");

        InstructorResponseDto dto = new InstructorResponseDto();
        dto.setInstructorId(1L);
        dto.setName("New");

        when(instructorRepository.findById(1L)).thenReturn(Optional.of(instructor));
        when(instructorRepository.save(instructor)).thenReturn(updated);
        when(instructorMapper.toDTO(updated)).thenReturn(dto);

        InstructorResponseDto result = instructorService.updateInstructor(1L, request);

        assertEquals("New", result.getName());
        verify(instructorRepository).save(instructor);
    }

    @Test
    void updateInstructor_notFound() {
        Long id = 1L;

        InstructorRequestDto request = new InstructorRequestDto();
        request.setName("New");
        request.setQualification("PhD");

        when(instructorRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,() -> instructorService.updateInstructor(id,request));
    }

    @Test
    void deleteInstructor() {
    }

    @Test
    void getInstructorsByNamePrefix() {
        Instructor instructor1 = new Instructor();
        instructor1.setInstructorId(1L);
        instructor1.setName("John");

        Instructor instructor2 = new Instructor();
        instructor2.setInstructorId(2L);
        instructor2.setName("Rahul");

        InstructorResponseDto dto1 = new InstructorResponseDto();
        dto1.setInstructorId(1L);
        dto1.setName("John");

        InstructorResponseDto dto2 = new InstructorResponseDto();
        dto2.setInstructorId(2L);
        dto2.setName("Rahul");

        Instructor instructor3 = new Instructor();
        instructor3.setInstructorId(3L);
        instructor3.setName("Jones");

        Instructor instructor4 = new Instructor();
        instructor4.setInstructorId(4L);
        instructor4.setName("Ram");

        InstructorResponseDto dto3 = new InstructorResponseDto();
        dto3.setInstructorId(3L);
        dto3.setName("Jones");

        InstructorResponseDto dto4 = new InstructorResponseDto();
        dto4.setInstructorId(4L);
        dto4.setName("Ram");

        when(instructorRepository.findByNameStartingWithIgnoreCase("Jo")).thenReturn(List.of(instructor1,instructor3));
        when(instructorRepository.findByNameStartingWithIgnoreCase("Ra")).thenReturn(List.of(instructor2,instructor4));

        when(instructorMapper.toDTO(instructor1)).thenReturn(dto1);
        when(instructorMapper.toDTO(instructor2)).thenReturn(dto2);
        when(instructorMapper.toDTO(instructor3)).thenReturn(dto3);
        when(instructorMapper.toDTO(instructor4)).thenReturn(dto4);

        List<InstructorResponseDto> result1 = instructorService.getInstructorsByNamePrefix("Jo");
        List<InstructorResponseDto> result2 = instructorService.getInstructorsByNamePrefix("Ra");

        assertEquals(2,result1.size());
        assertEquals("John", result1.get(0).getName());
        assertEquals("Jones",result1.get(1).getName());

        assertEquals(2,result2.size());
        assertEquals("Rahul", result2.get(0).getName());
        assertEquals("Ram",result2.get(1).getName());
    }
}