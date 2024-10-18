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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("Nutritionists")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name = "Nutritionist", description = "User Nutritionist")

public class NutritionistController {


    @Autowired
    private NutritionistService NutritionistService;

    @Operation ( summary = "Get all Nutritionist")
	@ApiResponse(responseCode = "200", description = "Found Nutritionist", content = {
	@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Nutritionist.class))) })

    @GetMapping
    public List<Nutritionist> getAll() {
        return NutritionistService.getAll();
    }
	@Operation(summary = "Get a Activity by his or her control number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Activity found", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Nutritionist.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Nutritionist", content = @Content),
			@ApiResponse(responseCode = "404", description = "Nutritionist not found", content = @Content) })

    @GetMapping("{NutritionistId}")
    public ResponseEntity<Nutritionist> getByNutritionistId(@PathVariable Integer NutritionistId) {
        Nutritionist nutritionist = NutritionistService.getByNutritionistId(NutritionistId);
        return new ResponseEntity <Nutritionist> (nutritionist, HttpStatus.OK);
    }

    @PostMapping
    public void registrar(@RequestBody Nutritionist nutritionist) {
        NutritionistService.save(nutritionist);
    }


    @PutMapping("{NutritionistId}")
    public ResponseEntity<?> update(@RequestBody Nutritionist Nutritionist, @PathVariable Integer NutritionistId) {

            Nutritionist auxNutritionist = NutritionistService.getByNutritionistId(NutritionistId);
            Nutritionist.setNutritionistId(auxNutritionist.getNutritionistId());
            NutritionistService.save(Nutritionist);
            return new ResponseEntity<String>("Updated record", HttpStatus.OK);
        }

    @DeleteMapping("{NutritionistId}")
    public ResponseEntity<?> delete(@PathVariable Integer IdNutritionist) {
        NutritionistService.delete(IdNutritionist);
        return new ResponseEntity<String>("Deleted record", HttpStatus.OK);
    }

}
