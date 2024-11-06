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
import org.springframework.web.bind.annotation.RestController;

import com.example.alimentaTec.model.Goal;
import com.example.alimentaTec.service.GoalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("goals")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

@Tag(name = "Goal", description = "Types of goals")
public class GoalController {

	@Autowired
	private GoalService service;

	@Operation(summary = "Get all Goal")
	@ApiResponse(responseCode = "200", description = "Found Goal", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Goal.class))) })
	@GetMapping
	public List<Goal> getAll() {
		return service.getAll();
	}

	@Operation(summary = "Get a Goal by his or her Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Goal found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Goal.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid control number supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Goal not found", content = @Content) })

	@GetMapping("{idGoal}")
	public ResponseEntity<?> getByIdgoal(@PathVariable Integer idGoal) {
		Goal goal = service.getByIdGoal(idGoal);
		return new ResponseEntity<Goal>(goal, HttpStatus.OK);
	}

	@Operation(summary = "Get a Goal by his or her name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Goal found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Goal.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Goal", content = @Content),
			@ApiResponse(responseCode = "404", description = "Goal not found", content = @Content) })
	@GetMapping("/{nameGoal}/name")
	public List<Goal> buscarNameSaucer(@PathVariable String nameGoal) {
		return service.buscarPorNombre(nameGoal);
	}
	@Operation(summary = "Register a Goal")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Goal registered", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Goal.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Goal", content = @Content) })
	@PostMapping
	public ResponseEntity<?> register(@RequestBody Goal goal) {
		service.save(goal);
		return new ResponseEntity<String>("Saved record", HttpStatus.OK);
	}
	@Operation(summary = "Update a Goal")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Goal updated", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Goal.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Goal", content = @Content) })
	@PutMapping("{idGoal}")
	public ResponseEntity<?> update(@RequestBody Goal goal, @PathVariable Integer idGoal) {
		Goal auxGoal = service.getByIdGoal(idGoal);
		goal.setIdGoal(auxGoal.getIdGoal());
		service.save(goal);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

}
