package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.Nutritionist;
import com.example.alimentaTec.repository.NutritionistRepository;


@Service

public class NutritionistService {

    @Autowired
	private NutritionistRepository repo;

	public List<Nutritionist> getAll() {
		return repo.findAll();
	}

	public void save(Nutritionist Nutritionist) {
		repo.save(Nutritionist);
	}

	public Nutritionist getByNutritionistId(Integer NutritionistId) {
		return repo.findById( NutritionistId).get();
	}

	public void delete(Integer NutritionistId) {
		repo.deleteById(NutritionistId);
	}
}
