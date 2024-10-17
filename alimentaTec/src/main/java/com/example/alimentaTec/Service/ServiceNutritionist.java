package com.example.alimentaTec.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.Model.Nutritionist;
import com.example.alimentaTec.Repository.NutritionistRepository;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class ServiceNutritionist {
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
