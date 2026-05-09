package com.tss.day39.task.controller;

import com.tss.day39.task.service.StudentCourseService;
import com.tss.day39.task.service.StudentCourseServiceImplementation;
import utils.InputUtil;

import java.util.List;

public class StudentCourseController {
    private StudentCourseService studentCourseService = new StudentCourseServiceImplementation();


    public void assignCourse(){
        int enrollNumber = InputUtil.readInt("Enter student's enrollment id: ");

        int courseId = InputUtil.readInt("Enter course id: ");

        studentCourseService.assignCourse(enrollNumber,courseId);
    }

    public void getCoursesByStudent(){
        int enrollNumber = InputUtil.readInt("Enter student's enrollment id: ");

        List<String> courses = studentCourseService.getCoursesOfStudent(enrollNumber);

        courses.forEach(System.out::println);
    }

    public void getStudentsByCourse(){
        int courseId = InputUtil.readInt("Enter course id: ");

        List<String> students = studentCourseService.getStudentsOfCourse(courseId);

        students.forEach(System.out::println);
    }
}
