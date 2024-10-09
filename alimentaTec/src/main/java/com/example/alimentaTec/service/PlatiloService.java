package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.PlatillosModel;
import com.example.alimentaTec.repository.PlatilloRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlatiloService {
    @Autowired
	private PlatilloRepository repo;

	public List<PlatillosModel> getAll() {
		return repo.findAll();
	}

	public void save(PlatillosModel platillosModel) {
		repo.save(platillosModel);
	}

	public PlatillosModel getDish_id(Integer dish_id) {
		return repo.findById(dish_id).get();
	}

	public void delete(Integer dish_id) {
		repo.deleteById(dish_id);
	}
}