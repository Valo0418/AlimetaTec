package com.example.alimentaTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.SaucerModel;

@Repository
public interface SaucerRepository extends JpaRepository<SaucerModel, Integer> {
    
}