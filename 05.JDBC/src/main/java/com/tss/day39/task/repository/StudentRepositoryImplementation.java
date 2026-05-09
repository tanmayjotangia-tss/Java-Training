package com.tss.day39.task.repository;

import com.tss.day39.task.config.DBConnection;
import com.tss.day39.task.entity.Address;
import com.tss.day39.task.entity.Student;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImplementation implements StudentRepository {

    private Connection connection = DBConnection.connect();

    @Override
    public List<Student> readStudents() {

        List<Student> students = new ArrayList<>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT s.enroll_number, s.name, s.age, " +
                    "a.city, a.state, a.pincode " +
                    "FROM students s " +
                    "LEFT JOIN address a ON s.enroll_number = a.enroll_number");

            while (resultSet.next()) {

                Address address = new Address();

                address.setCity(resultSet.getString("city"));
                address.setState(resultSet.getString("state"));
                address.setPincode(resultSet.getString("pincode"));

                students.add(new Student(
                        resultSet.getInt("enroll_number"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        address
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    @Override
    public void addNewStudent(Student student, Address address) {

        try {

            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO students(name,age) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {

                int enrollNumber = rs.getInt(1);

                PreparedStatement addressStmt = connection.prepareStatement(
                        "INSERT INTO address(enroll_number, city, state, pincode) VALUES(?,?,?,?)"
                );

                addressStmt.setInt(1, enrollNumber);
                addressStmt.setString(2, address.getCity());
                addressStmt.setString(3, address.getState());
                addressStmt.setString(4, address.getPincode());

                addressStmt.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}