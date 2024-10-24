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
@RequestMapping("UsersPatient")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name = "User Patient", description = "Various users patient")

public class UserPatientController {

    @Autowired
    private UserPatientService userPatientService;

    @Operation(summary = "Gnameuser patient")
	@ApiResponse(responseCode = "200", description = "Found patient", content = {
	@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserPatient.class))) })

    @GetMapping
    public List<UserPatient> getAll() {
        return userPatientService.getAll();
    }

    
	@Operation(summary = "Get a Activity by his or her control number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Patient found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserPatient.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Patient", content = @Content),
			@ApiResponse(responseCode = "404", description = "User Patient not found", content = @Content) })

    @GetMapping("{userPatientId}")
    public ResponseEntity <UserPatient> getByUserPatientId(@PathVariable Integer userPatientId) {
        UserPatient userPatient = (UserPatient) userPatientService.getByUserPatientId(userPatientId);
        return new ResponseEntity<UserPatient>(userPatient, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody UserPatient userPatient) {
        userPatientService.save(userPatient);
        return new ResponseEntity<String>("Saved record", HttpStatus.OK);

    }

    @PutMapping("{userPatientId}")
    public ResponseEntity<?> update(@RequestBody UserPatient userPatient, @PathVariable Integer userPatientId) {
    
            UserPatient auxUserPatient = userPatientService.getByUserPatientId(userPatientId);
            userPatient.setUserPatientId(auxUserPatient.getUserPatientId());
            userPatientService.save(userPatient);
            return new ResponseEntity<String>("Updated record", HttpStatus.OK);

    }

    @DeleteMapping("{userPatientId}")
    public ResponseEntity<?>  delete(@PathVariable Integer userPatientId) {
        userPatientService.delete(userPatientId);
		return new ResponseEntity<String>("Deleted record", HttpStatus.OK);

    }

}
