package com.tss.day39.task.service;

import com.tss.day39.task.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    void addNewCourse(Course course);
}
