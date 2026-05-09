package com.tss.advancedmappingapp.repository;

import com.tss.advancedmappingapp.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {

    List<Instructor> findByNameStartingWithIgnoreCase(String prefix);
}
