package com.tss.day39.task.entity;

public class Course {

    private int courseId;
    private String courseName;
    private int fees;

    // Default constructor
    public Course() {
    }

    // Constructor without id
    public Course(String courseName, int fees) {
        this.courseName = courseName;
        this.fees = fees;
    }

    // Constructor with id
    public Course(int courseId, String courseName, int fees) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fees = fees;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", fees=" + fees +
                '}';
    }
}