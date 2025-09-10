package com.example.service;

import com.example.entity.Person;
import com.example.entity.Aadhar;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person save(Person person) {
        if (person.getAadhar() != null) {
            person.getAadhar().setPerson(person); // Set back-reference
        }
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Person not found with id: " + id));
    }

    public Person findByName(String name) {
        return personRepository.findByName(name)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Person not found with name: " + name));
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public void delete(Long id) {
        if (!personRepository.existsById(id)) {
            throw new ResourceNotFoundException("Person not found with id: " + id);
        }
        personRepository.deleteById(id);
    }

    public Person update(Person person) {
        Person existing = personRepository.findById(person.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Person not found with id: " + person.getId()));

        existing.setName(person.getName());
        existing.setAge(person.getAge());

        Aadhar incomingAadhar = person.getAadhar();
        if (incomingAadhar != null) {
            incomingAadhar.setPerson(existing); // Set back-reference

            if (existing.getAadhar() != null) {
                existing.getAadhar().setAadharNumber(incomingAadhar.getAadharNumber());
                existing.getAadhar().setAddress(incomingAadhar.getAddress());
            } else {
                existing.setAadhar(incomingAadhar);
            }
        }

        return personRepository.save(existing);
    }

    public Person findByAadharNumber(String aadharNumber) {
        return personRepository.findByAadharNumber(aadharNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Person not found with Aadhar number: " + aadharNumber));
    }
}
