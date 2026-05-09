package com.tss.day39.task.repository;

import com.tss.day39.task.entity.Address;
import com.tss.day39.task.entity.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> readStudents();

    void addNewStudent(Student student, Address address);

}