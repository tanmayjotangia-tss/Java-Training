package com.tss.hibernate.repository;

import com.tss.hibernate.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Page<Student> findByName(String name, Pageable pageable);

}
