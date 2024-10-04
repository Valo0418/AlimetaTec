package com.example.alimentaTec.Controller;

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

import com.example.alimentaTec.model.SaucerModel;
import com.example.alimentaTec.service.SaucerService;

@RestController
@RequestMapping("SaucerModel")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

public class SaucerController {

	@Autowired
	private SaucerService service;

	@GetMapping
	public List<SaucerModel> getAll() {
		return service.getAll();
	}

	@GetMapping("{dishid}")
	public ResponseEntity<SaucerModel> getdishId(@PathVariable Integer dishid) {
		SaucerModel saucerModel = service.getdishId(dishid);
		return new ResponseEntity<SaucerModel>(saucerModel, HttpStatus.OK);
	}

	@PostMapping
	public void register(@RequestBody SaucerModel saucerModel) {
		service.save(saucerModel);
	}

	@PutMapping("{getdishId}")
	public ResponseEntity<?> update(@RequestBody SaucerModel saucerModel, @PathVariable Integer getdishId) {

		SaucerModel auxSaucer = service.getdishId(getdishId);
		saucerModel.setdishId(auxSaucer.getdishId());
		service.save(saucerModel);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

	@DeleteMapping("{getdishId}")
	public void delete(@PathVariable Integer dishid) {
		service.delete(dishid);
	}

}