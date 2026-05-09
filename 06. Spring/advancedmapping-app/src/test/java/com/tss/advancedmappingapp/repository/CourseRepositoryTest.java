package com.tss.advancedmappingapp.repository;

import com.tss.advancedmappingapp.entity.Course;
import com.tss.advancedmappingapp.entity.Instructor;
import com.tss.advancedmappingapp.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void testFindCoursesWithInstructor() {
        Instructor instructor = new Instructor();
        instructor.setName("John");
        entityManager.persist(instructor);

        Course c1 = new Course();
        c1.setCourseName("Java");
        c1.setInstructor(instructor);

        Course c2 = new Course();
        c2.setCourseName("Spring");
        c2.setInstructor(instructor);

        entityManager.persist(c1);
        entityManager.persist(c2);

        entityManager.flush();

        List<Course> courses = courseRepository.findCoursesWithInstructor(instructor.getInstructorId());

        assertThat(courses).hasSize(2);
        assertThat(courses)
                .extracting(c -> c.getInstructor().getName())
                .containsOnly("John");
    }

    @Test
    void testCountByInstructorInstructorId() {
        Instructor instructor1 = new Instructor();
        instructor1.setName("A");
        entityManager.persist(instructor1);

        Instructor instructor2 = new Instructor();
        instructor2.setName("B");
        entityManager.persist(instructor2);

        Course c1 = new Course();
        c1.setCourseName("Course1");
        c1.setInstructor(instructor1);

        Course c2 = new Course();
        c2.setCourseName("Course2");
        c2.setInstructor(instructor1);

        Course c3 = new Course();
        c3.setCourseName("Course3");
        c3.setInstructor(instructor2);

        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(c3);

        entityManager.flush();

        long count1 = courseRepository.countByInstructorInstructorId(instructor1.getInstructorId());
        long count2 = courseRepository.countByInstructorInstructorId(instructor2.getInstructorId());

        assertThat(count1).isEqualTo(2);
        assertThat(count2).isEqualTo(1);
    }

    @Test
    void testFindByIdWithStudents() {
        Course course = new Course();
        course.setCourseName("Hibernate");

        entityManager.persist(course);

        Student s1 = new Student();
        s1.setName("Alice");

        Student s2 = new Student();
        s2.setName("Bob");

        s1.setCourses(List.of(course));
        s2.setCourses(List.of(course));

        entityManager.persist(s1);
        entityManager.persist(s2);

        entityManager.flush();
        entityManager.clear();

        Optional<Course> result = courseRepository.findByIdWithStudents(course.getCourseId());

        assertThat(result).isPresent();
        assertThat(result.get().getStudents()).hasSize(2);
    }
}