package com.tss.day39.task.controller;

import com.tss.day39.task.entity.Address;
import com.tss.day39.task.entity.Student;
import com.tss.day39.task.service.StudentService;
import com.tss.day39.task.service.StudentServiceImplementation;
import utils.InputUtil;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentServiceImplementation();

    public void readAllStudents(){
        List<Student> students = studentService.getAllStudents();
        students.forEach(System.out::println);
    }

    public void addNewStudent(){

        System.out.println("Enter Student details : ");

        String name = InputUtil.readValidName("Enter name: ");
        int age = InputUtil.readInt("Enter age: ");

        System.out.println("Enter Address Details:");

        String city = InputUtil.readString("Enter city: ");
        String state = InputUtil.readString("Enter state: ");
        String pincode = InputUtil.readString("Enter pincode: ");

        Address address = new Address(city,state,pincode);

        Student student = new Student(name,age);

        studentService.addNewStudent(student,address);

        System.out.println("Student and address added successfully");
    }
}