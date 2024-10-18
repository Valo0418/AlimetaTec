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

	public Saucer getByIdSauser(Integer idSauser) {
		return repo.findById(idSauser).get();
	}	

	public void delete(Integer idSauser) {
		repo.deleteById(idSauser);
	}
}