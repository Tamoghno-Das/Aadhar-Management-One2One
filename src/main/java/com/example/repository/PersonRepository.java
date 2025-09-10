package com.example.repository;

import com.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.name = :name")
    Optional<Person> findByName(@Param("name") String name);

    @Query("SELECT p FROM Person p WHERE p.aadhar.aadharNumber = :aadharNumber")
    Optional<Person> findByAadharNumber(@Param("aadharNumber") String aadharNumber);
}
