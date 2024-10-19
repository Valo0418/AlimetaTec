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

import com.example.alimentaTec.model.Nutritionist;
import com.example.alimentaTec.service.NutritionistService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("Nutritionist")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

@Tag(name = "Nutritionist", description = "Types of Nutritionists")

public class NutritionistControler {
    

	@Autowired
	private NutritionistService service;

	@Operation(summary = "Get all Nutritionist")
	@ApiResponse(responseCode = "200", description = "Found Nutritionist", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Nutritionist.class))) })
	@GetMapping
	public List<Nutritionist> getAll() {
		return service.getAll();
	}

	@Operation(summary = "Get a Nutritionist by his or her Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Nutritionist found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Nutritionist.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid control number supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Nutritionist not found", content = @Content) })

	@GetMapping("{idNutritionist}")
	public ResponseEntity<?> getByIdNutritionist(@PathVariable Integer idNutritionist) {
		Nutritionist nutritionist = service.getByIdNutritionist(idNutritionist);
		return new ResponseEntity<Nutritionist>(nutritionist, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> register(@RequestBody Nutritionist nutritionist) {
		service.save(nutritionist);
		return new ResponseEntity<String>("Saved record", HttpStatus.OK);
	}

	@PutMapping("{idGoal}")
	public ResponseEntity<?> update(@RequestBody Nutritionist nutritionist, @PathVariable Integer idNutritionist) {
		Nutritionist auxNutritionist = service.getByIdNutritionist(idNutritionist);
		nutritionist.setIdNutritionist(auxNutritionist.getIdNutritionist());
		service.save(nutritionist);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

	@DeleteMapping("{idNutritionist}")
	public ResponseEntity<?> delete(@PathVariable Integer idNutritionist) {
		service.delete(idNutritionist);
		return new ResponseEntity<String>("Deleted record", HttpStatus.OK);
	}
}
