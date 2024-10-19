package com.example.alimentaTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {
    
}