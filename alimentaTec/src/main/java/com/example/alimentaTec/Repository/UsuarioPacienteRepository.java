package com.example.alimentaTec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alimentaTec.Model.UsuarioPaciente;

@Repository
public interface UsuarioPacienteRepository extends JpaRepository<UsuarioPaciente, Integer> {
    
}
