package com.example;

import com.example.entity.Aadhar;
import com.example.entity.Person;
import com.example.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testSaveAndFindPersonBidirectional() {
        Person person = new Person();
        person.setName("John");
        person.setAge(30);

        Aadhar aadhar = new Aadhar();
        aadhar.setAadharNumber("123456789012");
        aadhar.setAddress("Delhi");

        // set both sides
        person.setAadhar(aadhar);

        // save parent only; cascade will persist child with same id (via @MapsId)
        Person saved = personRepository.saveAndFlush(person);

        assertNotNull(saved.getId());
        assertNotNull(saved.getAadhar());
        assertEquals(saved.getId(), saved.getAadhar().getId());
        assertEquals("123456789012", saved.getAadhar().getAadharNumber());
    }
}

