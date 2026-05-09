package com.tss.day39.task.controller;

import com.tss.day39.task.entity.Course;
import com.tss.day39.task.service.CourseService;
import com.tss.day39.task.service.CourseServiceImplementation;
import utils.InputUtil;

import java.util.List;

public class CourseController {
    private CourseService courseService = new CourseServiceImplementation();

    void addNewCourse(){
        System.out.println("Enter course details: ");
        String courseName = InputUtil.readString("Enter course name: ");
        int fee = InputUtil.readInt("Enter course fee: ");
        Course course = new Course(courseName,fee);
        courseService.addNewCourse(course);
        System.out.println("Course added successfully");
    }

    void getAllCourse(){
        List<Course> courses = courseService.getAllCourses();
        courses.forEach(System.out::println);
    }
}
