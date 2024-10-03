package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.ActividadFisica;
import com.example.alimentaTec.repository.ActividadFisicaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ActividadFisicaService {
    @Autowired
    private ActividadFisicaRepository repo;

    public List<ActividadFisica> getAll(){
        return repo.findAll();
    }

    public void save(ActividadFisica student) {
		repo.save(student);
	}

	public ActividadFisica getById_actividad(Integer id_actividad) {
		return repo.findById(id_actividad).get();
	}

	public void delete(Integer id_actividad) {
		repo.deleteById(id_actividad);
	}
}