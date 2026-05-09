package com.tss.day39.task.repository;

import com.tss.day39.task.config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseRepositoryImplementation implements StudentCourseRepository {

    Connection connection = DBConnection.connect();

    @Override
    public void assignCourse(int enrollNumber, int courseId) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO student_course(enroll_number,course_id) VALUES(?,?)");
            ps.setInt(1,enrollNumber);
            ps.setInt(2,courseId);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());        }
    }

    @Override
    public List<String> getCoursesOfStudent(int enrollNumber) {

        List<String> courses = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT c.course_name FROM course c " +
                            "JOIN student_course sc ON c.course_id = sc.course_id " +
                            "WHERE sc.enroll_number = ?"
            );

            ps.setInt(1, enrollNumber);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                courses.add(rs.getString("course_name"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return courses;
    }

    @Override
    public List<String> getStudentsOfCourse(int courseId) {
        List<String> students = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT s.name FROM students s " +
                    "JOIN student_course sc ON s.enroll_number = sc.enroll_number " +
                    "WHERE sc.course_id = ?");

            ps.setInt(1,courseId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                students.add(rs.getString("name"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}