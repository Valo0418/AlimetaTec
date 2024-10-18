package com.example.alimentaTec.controller;

import java.util.List;
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

import com.example.alimentaTec.model.PhysicalActivity;
import com.example.alimentaTec.service.PhysicalActivityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("PhysicalActivity")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@Tag(name = "Physical Activity", description = "Provides methods for managing Physical Activity")
public class PhysicalActivityController {

	@Autowired
	private PhysicalActivityService service;
	
	@GetMapping
	public List<PhysicalActivity> getAll() {
		return service.getAll();
	}

	@GetMapping("{idActivity}")
	public ResponseEntity<PhysicalActivity> getByIdActivity(@PathVariable Integer idActivity) {
		PhysicalActivity physicalActivity = service.getByIdActivity(idActivity);
		return new ResponseEntity<PhysicalActivity>(physicalActivity, HttpStatus.OK);
	}

	@PostMapping
	public void register(@RequestBody PhysicalActivity physicalActivity) {
		service.save(physicalActivity);
	}

	@PutMapping("{idActivity}")
	public ResponseEntity<?> update(@RequestBody PhysicalActivity physicalActivity, @PathVariable Integer idActivity) {

		PhysicalActivity auxStudent = service.getByIdActivity(idActivity);
		physicalActivity.setIdActivity(auxStudent.getIdActivity());
		service.save(physicalActivity);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

	@DeleteMapping("{idActivity}")
	public void delete(@PathVariable Integer idActivity) {
		service.delete(idActivity);
	}

}
