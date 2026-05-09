package com.tss.day39.task.repository;

import java.util.List;

public interface StudentCourseRepository {

    void assignCourse(int enrollNumber, int courseId);

    List<String> getCoursesOfStudent(int enrollNumber);

    List<String> getStudentsOfCourse(int courseId);

}