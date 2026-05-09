package com.tss.advancedmappingapp.repository;

import com.tss.advancedmappingapp.entity.Instructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class InstructorRepositoryTest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Test
    void testFindByNameStartingWithIgnoreCase() {
        Instructor i1 = new Instructor();
        i1.setName("John Doe");

        Instructor i2 = new Instructor();
        i2.setName("Johnny Bravo");

        instructorRepository.save(i1);
        instructorRepository.save(i2);

        List<Instructor> result =
                instructorRepository.findByNameStartingWithIgnoreCase("jo");

        assertThat(result).hasSize(2);
    }

    @Test
    void testFindByNameStartingWithIgnoreCase_MixedCase() {
        Instructor i1 = new Instructor();
        i1.setName("john");

        Instructor i2 = new Instructor();
        i2.setName("JOHNSON");

        Instructor i3 = new Instructor();
        i3.setName("Joanna");

        instructorRepository.saveAll(List.of(i1, i2, i3));

        List<Instructor> result =
                instructorRepository.findByNameStartingWithIgnoreCase("Jo");

        assertThat(result).hasSize(3);
    }

    @Test
    void testFindByNameStartingWithIgnoreCase_StrictPrefix() {
        Instructor i1 = new Instructor();
        i1.setName("Ajay");

        Instructor i2 = new Instructor();
        i2.setName("Vijay");

        instructorRepository.saveAll(List.of(i1, i2));

        List<Instructor> result =
                instructorRepository.findByNameStartingWithIgnoreCase("jay");

        assertThat(result).isEmpty();
    }


    @Test
    void testFindByNameStartingWithIgnoreCase_EmptyDatabase() {
        List<Instructor> result =
                instructorRepository.findByNameStartingWithIgnoreCase("A");

        assertThat(result).isEmpty();
    }
}