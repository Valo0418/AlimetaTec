package com.example.alimentaTec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.Model.UserPatient;

@Repository
public interface UserPatientRepository extends JpaRepository<UserPatient, Integer> {
    
}
