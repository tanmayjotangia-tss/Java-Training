package com.tss.day27;

public class Student {
    private StudentService studentService;

    public Student(StudentService studentService) {
        this.studentService = studentService;
    }

    public double calculatePercentage(){
        return ((double) studentService.getTotalMarks() /studentService.getTotalStudents())*100;
    }
}
