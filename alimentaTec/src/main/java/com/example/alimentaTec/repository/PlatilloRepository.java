package com.example.alimentaTec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.model.PlatillosModel;

@Repository
public interface PlatilloRepository extends JpaRepository<PlatillosModel, Integer>{
}
