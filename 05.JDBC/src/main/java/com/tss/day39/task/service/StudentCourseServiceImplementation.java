package com.tss.day39.task.service;

import com.tss.day39.task.repository.StudentCourseRepository;
import com.tss.day39.task.repository.StudentCourseRepositoryImplementation;

import java.util.List;

public class StudentCourseServiceImplementation implements StudentCourseService{
private StudentCourseRepository studentCourseRepository = new StudentCourseRepositoryImplementation();
    @Override
    public void assignCourse(int enrollNumber, int courseId) {
        studentCourseRepository.assignCourse(enrollNumber,courseId);
    }

    @Override
    public List<String> getCoursesOfStudent(int enrollNumber) {
        return studentCourseRepository.getCoursesOfStudent(enrollNumber);
    }

    @Override
    public List<String> getStudentsOfCourse(int courseId) {
        return studentCourseRepository.getStudentsOfCourse(courseId);
    }
}
