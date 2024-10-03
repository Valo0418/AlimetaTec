package com.example.alimentaTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.ActividadFisica;

@Repository
public interface ActividadFisicaRepository extends JpaRepository<ActividadFisica, Integer> {
    
}
