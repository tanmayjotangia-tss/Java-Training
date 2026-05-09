package com.tss.day39.task.service;

import com.tss.day39.task.entity.Address;
import com.tss.day39.task.entity.Student;
import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void addNewStudent(Student student, Address address);

}