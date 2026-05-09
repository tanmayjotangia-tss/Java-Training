package com.tss.day39.task.service;

import com.tss.day39.task.entity.Address;
import com.tss.day39.task.entity.Student;
import com.tss.day39.task.repository.StudentRepository;
import com.tss.day39.task.repository.StudentRepositoryImplementation;

import java.util.List;

public class StudentServiceImplementation implements StudentService{
    private StudentRepository studentRepository = new StudentRepositoryImplementation();

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.readStudents();
    }

    @Override
    public void addNewStudent(Student student, Address address) {
        studentRepository.addNewStudent(student,address);
    }
}
