package com.tss.day27;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private static Student student;
    private static StudentService studentService;

    @BeforeAll
    static void init(){
        studentService = Mockito.mock(StudentService.class);
        student = new Student(studentService);
    }

    @Test
    void calculatePercentage() {
        Mockito.when(studentService.getTotalMarks()).thenReturn(50);
        Mockito.when(studentService.getTotalStudents()).thenReturn(100);
        assertEquals(50,student.calculatePercentage());
    }
}