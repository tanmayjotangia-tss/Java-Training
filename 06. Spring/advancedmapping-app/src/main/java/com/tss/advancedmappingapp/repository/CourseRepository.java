package com.tss.advancedmappingapp.repository;

import com.tss.advancedmappingapp.entity.Course;
import com.tss.advancedmappingapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("SELECT c FROM Course c JOIN FETCH c.instructor WHERE c.instructor.instructorId = :instructorId")
    List<Course> findCoursesWithInstructor(@Param("instructorId") Long instructorId);
    long count();
    long countByInstructorInstructorId(Long instructorId);

    @Query("SELECT c FROM Course c LEFT JOIN FETCH c.students WHERE c.id = :id")
    Optional<Course> findByIdWithStudents(Long id);
}
