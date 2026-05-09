package com.tss.hibernate.service;

import com.tss.hibernate.dto.page.StudentPageResponseDTO;
import com.tss.hibernate.dto.request.StudentRequestDTO;
import com.tss.hibernate.dto.response.StudentResponseDTO;


public interface StudentService {

    StudentPageResponseDTO findAll(Integer pageSize, Integer pageNumber);

    StudentPageResponseDTO getByName(String name,Integer pageSize, Integer pageNumber);

    StudentResponseDTO addStudent(StudentRequestDTO student);

    void deleteStudent(int id);

    StudentResponseDTO updateStudent(int id, StudentRequestDTO student);

    StudentResponseDTO findStudentById(int id);
}
