package com.tss.advancedmappingapp.repository;

import com.tss.advancedmappingapp.entity.Course;
import com.tss.advancedmappingapp.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindByIdWithCourses() {
        Course c1 = new Course();
        c1.setCourseName("Java");

        Course c2 = new Course();
        c2.setCourseName("Spring");

        entityManager.persist(c1);
        entityManager.persist(c2);

        Student student = new Student();
        student.setName("Tanmay");

        student.setCourses(new ArrayList<>());
        c1.setStudents(new ArrayList<>());
        c2.setStudents(new ArrayList<>());

        student.getCourses().add(c1);
        student.getCourses().add(c2);

        c1.getStudents().add(student);
        c2.getStudents().add(student);

        entityManager.persist(student);

        entityManager.flush();
        entityManager.clear();

        Optional<Student> result = studentRepository.findByIdWithCourses(student.getId());


        assertThat(result).isPresent();
        assertThat(result.get().getCourses()).hasSize(2);
    }
}