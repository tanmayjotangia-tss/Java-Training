package com.tss.day39.task.controller;

import utils.InputUtil;

public class MainController {
    private StudentController studentController = new StudentController();
    private CourseController courseController = new CourseController();
    private StudentCourseController studentCourseController = new StudentCourseController();

    static void displayMenu(){
        System.out.println("-----------------------Student Management System-----------------------");
        System.out.println("1. Add Student");
        System.out.println("2. Add course");
        System.out.println("3. Assign Course to Student");
        System.out.println("4. Read all Students");
        System.out.println("5. Read all Courses");
        System.out.println("6. Read Students of perticular Course");
        System.out.println("7. Read Courses of perticular Student");
        System.out.println("8. Exit");
    }


    public void start(){
        while(true){
            displayMenu();

            int choice = InputUtil.readInt("Enter your choice: ");
            switch (choice){
                case 1 -> studentController.addNewStudent();
                case 2 -> courseController.addNewCourse();
                case 3 -> studentCourseController.assignCourse();
                case 4 -> studentController.readAllStudents();
                case 5 -> courseController.getAllCourse();
                case 6 -> studentCourseController.getStudentsByCourse();
                case 7 -> studentCourseController.getCoursesByStudent();
                case 8 -> {
                    return;
                }
                default -> System.out.println("Enter valid choice");
            }
        }
    }
}
