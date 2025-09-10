package com.example.repository;

import com.example.entity.Aadhar;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AadharRepository extends JpaRepository<Aadhar, Long> {

    @Query("SELECT a FROM Aadhar a WHERE a.person.name = :name")
    Optional<Aadhar> findByPersonName(String name);

    @Query("SELECT a FROM Aadhar a WHERE a.aadharNumber = :aadharNumber")
    Optional<Aadhar> findByAadharNumber(String aadharNumber);
}
