package com.example.alimentaTec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.Model.Nutriologo;

@Repository
public interface NutriologoRepository extends JpaRepository<Nutriologo, Integer> {
    
}
