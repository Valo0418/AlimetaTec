package com.example.alimentaTec.Controller;

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

import com.example.alimentaTec.model.PlatillosModel;
import com.example.alimentaTec.service.PlatiloService;

@RestController
@RequestMapping("platillos")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class PlatilloController {
    
    @Autowired
    private PlatiloService PlatiloService;

    @GetMapping
    public List<PlatillosModel> getAll(){
        return PlatiloService.getAll();
    }


    @GetMapping("{dish_id}")
    public ResponseEntity <PlatillosModel> getDish_id (@PathVariable Integer dish_id){
        PlatillosModel platillosModel = PlatiloService.getDish_id(dish_id);
        return new ResponseEntity<PlatillosModel>(platillosModel, HttpStatus.OK);
    }

	@PostMapping
	public void registrar(@RequestBody PlatillosModel platillosModel) {
		PlatiloService.save(platillosModel);
	}

	@PutMapping("{dish_id}")
	public ResponseEntity<?> update(@RequestBody PlatillosModel platillosModel, @PathVariable Integer dish_id) {
		try {
			PlatillosModel auxplarPlatillosModel = PlatiloService.getDish_id(dish_id);
			platillosModel.setDish_id(auxplarPlatillosModel.getDish_id());
			PlatiloService.save(platillosModel);
			return new ResponseEntity<String>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
	        return new ResponseEntity<String>("The record with the control number provided is not found in the database", HttpStatus.NOT_FOUND);
	    }
	}

	@DeleteMapping("{dish_id}")
	public void delete(@PathVariable Integer dish_id) {
		PlatiloService.delete(dish_id);
	}
    
}