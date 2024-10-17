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
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })


@Tag(name = "Saucer", description = "Various types of saucers")
public class SaucerController {

	@Autowired
	private SaucerService service;

	@Operation(summary = "Get all Saucer")
	@ApiResponse(responseCode = "200", description = "Found Saucer", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Saucer.class))) })
	@GetMapping
	public List<Saucer> getAll() {
		return service.getAll();
	}

	@Operation(summary = "Get a Saucer by his or her ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Saucer found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Saucer.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Saucer", content = @Content),
			@ApiResponse(responseCode = "404", description = "Saucer not found", content = @Content) })
	@GetMapping("{idSauser}")
	public ResponseEntity<?> getByIdSauser(@PathVariable Integer idSauser) {
		Saucer saucer = service.getByIdSauser(idSauser);
		return new ResponseEntity<Saucer>(saucer, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> register(@RequestBody Saucer saucer) {
		service.save(saucer);
		return new ResponseEntity<String>("Saved record", HttpStatus.OK);
	
	}

	@PutMapping("{idSauser}")
	public ResponseEntity<?> update(@RequestBody Saucer saucer, @PathVariable Integer idSauser) {
		Saucer auxSaucer = service.getByIdSauser(idSauser);
		saucer.setIdSauser(auxSaucer.getIdSauser());
		service.save(saucer);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

	@DeleteMapping("{idSauser}")
	public ResponseEntity<?> delete(@PathVariable Integer idSauser) {
		service.delete(idSauser);
		return new ResponseEntity<String>("Delete record", HttpStatus.OK);
	
	}

}
