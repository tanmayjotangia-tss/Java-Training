package com.tss.day39.task.repository;

import com.tss.day39.task.config.DBConnection;
import com.tss.day39.task.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImplementation implements CourseRepository {

    private Connection connection = DBConnection.connect();

    @Override
    public List<Course> readCourses() {

        List<Course> courses = new ArrayList<>();

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM course");

            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("fee")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return courses;
    }


    @Override
    public void addCourse(Course course) {

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO course(course_name,fee) VALUES(?,?)");

            ps.setString(1, course.getCourseName());
            ps.setInt(2, course.getFees());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}