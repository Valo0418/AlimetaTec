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

import com.example.alimentaTec.model.ActividadFisica;
import com.example.alimentaTec.service.ActividadFisicaService;

@RestController
@RequestMapping("ActividadFisica")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

public class ActividadFisicaController {

	@Autowired
	private ActividadFisicaService service;

	@GetMapping
	public List<ActividadFisica> getAll() {
		return service.getAll();
	}

	@GetMapping("{id_actividad}")
	public ResponseEntity<ActividadFisica> getById_actividad(@PathVariable Integer id_actividad) {
		ActividadFisica actividadFisica = service.getById_actividad(id_actividad);
		return new ResponseEntity<ActividadFisica>(actividadFisica, HttpStatus.OK);
	}

	@PostMapping
	public void registrar(@RequestBody ActividadFisica actividadFisica) {
		service.save(actividadFisica);
	}

	@PutMapping("{id_actividad}")
	public ResponseEntity<?> update(@RequestBody ActividadFisica actividadFisica, @PathVariable Integer id_actividad) {

		ActividadFisica auxStudent = service.getById_actividad(id_actividad);
		actividadFisica.setId_actividad(auxStudent.getId_actividad());
		service.save(actividadFisica);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

	@DeleteMapping("{id_actividad}")
	public void delete(@PathVariable Integer id_actividad) {
		service.delete(id_actividad);
	}

}
