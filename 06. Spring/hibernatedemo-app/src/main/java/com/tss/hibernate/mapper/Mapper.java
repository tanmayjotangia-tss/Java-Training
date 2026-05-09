package com.tss.hibernate.mapper;

import com.tss.hibernate.dto.request.StudentRequestDTO;
import com.tss.hibernate.dto.response.StudentResponseDTO;
import com.tss.hibernate.entity.Student;
import com.tss.hibernate.repository.StudentRepository;

public class Mapper {
    private static StudentRepository studentRepo;

//    public Mapper(StudentRepository studentRepo) {
//        this.studentRepo = studentRepo;
//    }

    public static Student studentRequestToStudentMapper(StudentRequestDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(student.getAge());
        return  studentRepo.save(student);
    }

    public static StudentResponseDTO studentToStudentRespondDTOMapper(Student student){
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setId(student.getStudentId());
        responseDTO.setName(student.getName());
        return responseDTO;
    }
}
