package com.example.alimentaTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.UserPatient;

@Repository
public interface UserPatientRepository extends JpaRepository<UserPatient, Integer> {
    
}
