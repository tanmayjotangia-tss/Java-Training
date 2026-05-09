package com.tss.day39.task.service;

import java.util.List;

public interface StudentCourseService {

    void assignCourse(int enrollNumber, int courseId);

    List<String> getCoursesOfStudent(int enrollNumber);

    List<String> getStudentsOfCourse(int courseId);
}
