package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.SaucerModel;
import com.example.alimentaTec.repository.SaucerRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SaucerService {
    @Autowired
    private SaucerRepository repo;

    public List<SaucerModel> getAll(){
        return repo.findAll();
    }

    public void save(SaucerModel saucerModel) {
		repo.save(saucerModel);
	}

	public SaucerModel getdishId(Integer dishid) {
		return repo.findById(dishid).get();
	}

	public void delete(Integer dishid) {
		repo.deleteById(dishid);
	}
}