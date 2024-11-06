package com.example.alimentaTec.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.alimentaTec.model.Saucer;
import com.example.alimentaTec.service.SaucerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("saucer")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT })
@Tag(name = "Saucers", description = "Various types of saucers")

public class SaucerController {

	@Autowired
	SaucerService service;

	@Operation(summary = "Get all accounts with pagination")
	@GetMapping(value = "pagination", params = { "page", "size" })
	public List<Saucer> getAllPaginated(@RequestParam(value = "page", defaultValue = "0", required = false) int 
	page,
	
	@RequestParam(value = "size", defaultValue = "10", required = false) int pageSize) {
		List<Saucer> saucer = service.getAll(page, pageSize);
		return saucer;
	}


	@Operation(summary = "Get Saurce by Id")
	@GetMapping("{idSaucer}")
	public ResponseEntity<?> getByIdSaucer(@PathVariable Integer idSaucer) {
		Saucer saucer = service.getByIdSaucer(idSaucer);
		return new ResponseEntity<Saucer>(saucer, HttpStatus.OK);
	}

	@Operation(summary = "Get all Saucer")
	@ApiResponse(responseCode = "200", description = "Found Saucer", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Saucer.class))) })

	@GetMapping
	public List<Saucer> getAll() {
		return service.getAll();
	}
	
	@Operation(summary = "Create saurce")
	@PostMapping
	public ResponseEntity<?> register(@RequestBody Saucer saucer) {
		service.save(saucer);
		return new ResponseEntity<String>("Saved record", HttpStatus.OK);
	}



	@Operation(summary="Update saurce by Id")
	@PutMapping("{idSaucer}")
	public ResponseEntity<?> update(@RequestBody Saucer saucer, @PathVariable Integer idSaucer) {
		Saucer auxSaucer = service.getByIdSaucer(idSaucer);
		saucer.setIdSaucer(auxSaucer.getIdSaucer());
		service.save(saucer);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}
	@Operation(summary = "Get a Saucer by his or her name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Saucer found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Saucer.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Saucer", content = @Content),
			@ApiResponse(responseCode = "404", description = "Saucer not found", content = @Content) })
			
	@GetMapping("/{nameSaucer}/name")
	public List<Saucer> searchbyNameSaucer(@PathVariable String nameSaucer) {
		return service.searchbyName(nameSaucer);
	}

}