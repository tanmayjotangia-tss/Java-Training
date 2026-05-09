package com.tss.day39.task.repository;

import com.tss.day39.task.entity.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> readCourses();

    void addCourse(Course course);
}
