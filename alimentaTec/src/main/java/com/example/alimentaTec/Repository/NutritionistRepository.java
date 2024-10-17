package com.example.alimentaTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.Nutritionist;

@Repository
public interface NutritionistRepository extends JpaRepository<Nutritionist, Integer> {
    
}
