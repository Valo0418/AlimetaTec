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

import com.example.alimentaTec.model.Goal;
import com.example.alimentaTec.service.GoalService;

@RestController
@RequestMapping("Goal")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })

public class GoalController {

	@Autowired
	private GoalService service;

	@GetMapping
	public List<Goal> getAll() {
		return service.getAll();
	}

	@GetMapping("{idGoal}")
	public ResponseEntity<Goal> getByIdgoal(@PathVariable Integer idGoal) {
		Goal goal = service.getByIdGoal(idGoal);
		return new ResponseEntity<Goal>(goal, HttpStatus.OK);
	}

	@PostMapping
	public void register(@RequestBody Goal goal) {
		service.save(goal);
	}

	@PutMapping("{idGoal}")
	public ResponseEntity<?> update(@RequestBody Goal goal, @PathVariable Integer idGoal) {
		Goal auxGoal = service.getByIdGoal(idGoal);
		goal.setIdGoal(auxGoal.getIdGoal());
		service.save(goal);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}

	@DeleteMapping("{idGoal}")
	public void delete(@PathVariable Integer idGoal) {
		service.delete(idGoal);
	}

}
