package com.tss.day39.task.service;

import com.tss.day39.task.entity.Course;
import com.tss.day39.task.repository.CourseRepository;
import com.tss.day39.task.repository.CourseRepositoryImplementation;

import java.util.List;

public class CourseServiceImplementation implements CourseService{
    private CourseRepository courseRepository = new CourseRepositoryImplementation();

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.readCourses();
    }

    @Override
    public void addNewCourse(Course course) {
        courseRepository.addCourse(course);
    }
}
