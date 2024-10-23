package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.Saucer;
import com.example.alimentaTec.repository.SaucerRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SaucerService {
	@Autowired
	private SaucerRepository repo;

	public List<Saucer> getAll() {
		return repo.findAll();
	}

	public void save(Saucer saucer) {
		repo.save(saucer);
	}

	public Saucer getByIdSaucer(Integer idSaucer) {
		return repo.findById(idSaucer).get();
	}

	public void delete(Integer idSaucer) {
		repo.deleteById(idSaucer);
	}
	
	public List<Saucer> buscarPorNombre(String nameSaucer) {
        return repo.buscarPorNombre(nameSaucer);
    }
}