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

@RestController
@RequestMapping("saucer")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

public class SaucerController {

	@Autowired
	private SaucerService service;

	@GetMapping
	public List<Saucer> getAll() {
		return service.getAll();
	}

	@GetMapping("{idSauser}")
	public ResponseEntity<Saucer> getByIdSauser(@PathVariable Integer idSauser) {
		Saucer saucer = service.getByIdSauser(idSauser);
		return new ResponseEntity<Saucer>(saucer, HttpStatus.OK);
	}

	@PostMapping
	public void register(@RequestBody Saucer saucer) {
		service.save(saucer);
	}

	@PutMapping("{idSauser}")
	public ResponseEntity<?> update(@RequestBody Saucer saucer, @PathVariable Integer idSauser) {

		Saucer auxSaucer = service.getByIdSauser(idSauser);
		saucer.setIdSauser(auxSaucer.getIdSauser());
		service.save(saucer);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

	@DeleteMapping("{idSauser}")
	public void delete(@PathVariable Integer idSauser) {
		service.delete(idSauser);
	}

}
