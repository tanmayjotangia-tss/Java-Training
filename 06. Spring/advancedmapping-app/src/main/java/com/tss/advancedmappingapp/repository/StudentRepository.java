package com.tss.advancedmappingapp.repository;

import com.tss.advancedmappingapp.dto.response.StudentResponseDto;
import com.tss.advancedmappingapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.courses WHERE s.id = :id")
    Optional<Student> findByIdWithCourses(Long id);
}
