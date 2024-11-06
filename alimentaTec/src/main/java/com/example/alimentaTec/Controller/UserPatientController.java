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

import com.example.alimentaTec.model.UserPatient;
import com.example.alimentaTec.service.UserPatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("userPatient")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name = "User Patients", description = "Various users patient")

public class UserPatientController {

    @Autowired
    UserPatientService service;

    @Operation(summary = "Get all patients")
	@ApiResponse(responseCode = "200", description = "Found patient", content = {
	@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserPatient.class))) })

    @GetMapping
    public List<UserPatient> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Get a patient by his or her id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Patient found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = UserPatient.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid control number supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Patient not found", content = @Content) })
    @GetMapping("{userPatientId}")
    public ResponseEntity <UserPatient> getByUserPatientId(@PathVariable Integer userPatientId) {
        UserPatient userPatient = (UserPatient) service.getByUserPatientId(userPatientId);
        return new ResponseEntity<UserPatient>(userPatient, HttpStatus.OK);
    }

    @Operation(summary = "Register a patient")
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody UserPatient userPatient) {
        service.save(userPatient);
        return new ResponseEntity<String>("Saved record", HttpStatus.OK);

    }
    
    @Operation(summary = "Update a patient")
    @PutMapping("{userPatientId}")
    public ResponseEntity<?> update(@RequestBody UserPatient userPatient, @PathVariable Integer userPatientId) {
            UserPatient auxUserPatient = service.getByUserPatientId(userPatientId);
            userPatient.setUserPatientId(auxUserPatient.getUserPatientId());
            service.save(userPatient);
            return new ResponseEntity<String>("Updated record", HttpStatus.OK);
    }

    @Operation(summary = "Get a patient by his or her  name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Patient found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserPatient.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Patient", content = @Content),
			@ApiResponse(responseCode = "404", description = "User Patient not found", content = @Content) })
	@GetMapping ("/{userName}/name")
	public List<UserPatient> searchbyUserName (@PathVariable String userName){
	return service.searchbyUserName(userName);
	}

}
