package com.example.alimentaTec.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.alimentaTec.model.Nutritionist;
import com.example.alimentaTec.service.NutritionistService;

@RestController
@RequestMapping("Nutritionists")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class NutritionistController {

    @Autowired
    private NutritionistService NutritionistService;

    @GetMapping
    public List<Nutritionist> getAll() {
        return NutritionistService.getAll();
    }

    @GetMapping("{NutritionistId}")
    public ResponseEntity<Nutritionist> getByNutritionistId(@PathVariable Integer NutritionistId) {
        Nutritionist nutritionist = NutritionistService.getByNutritionistId(NutritionistId);
        return new ResponseEntity<Nutritionist>(nutritionist, HttpStatus.OK);
    }

    @PostMapping
    public void registrar(@RequestBody Nutritionist nutritionist) {
        NutritionistService.save(nutritionist);
    }

    @PutMapping("{NutritionistId}")
    public ResponseEntity<?> update(@RequestBody Nutritionist Nutritionist, @PathVariable Integer NutritionistId) {
        try {
            Nutritionist auxNutritionist = NutritionistService.getByNutritionistId(NutritionistId);
            Nutritionist.setNutritionistId(auxNutritionist.getNutritionistId());
            NutritionistService.save(Nutritionist);
            return new ResponseEntity<String>("Updated record", HttpStatus.OK);
        } catch (NoSuchElementException i) {
            return new ResponseEntity<String>("The record with the control number provided is not found in the database", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{NutritionistId}")
    public void delete(@PathVariable Integer IdNutritionist) {
        NutritionistService.delete(IdNutritionist);
    }

}
