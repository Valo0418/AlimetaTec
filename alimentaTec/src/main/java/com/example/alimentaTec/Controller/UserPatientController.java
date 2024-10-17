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
import com.example.alimentaTec.model.UserPatient;
import com.example.alimentaTec.service.UserPatientService;

@RestController
@RequestMapping("UsersPatient")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class UserPatientController {

    @Autowired
    private UserPatientService userPatientService;

    @GetMapping
    public List<UserPatient> getAll() {
        return userPatientService.getAll();
    }

    @GetMapping("{userPatientId}")
    public ResponseEntity <UserPatient> getByUserPatientId(@PathVariable Integer userPatientId) {
        UserPatient userPatient = (UserPatient) userPatientService.getByUserPatientId(userPatientId);
        return new ResponseEntity<UserPatient>(userPatient, HttpStatus.OK);
    }

    @PostMapping
    public void registrar(@RequestBody UserPatient userPatient) {
        userPatientService.save(userPatient);
    }

    @PutMapping("{userPatientId}")
    public ResponseEntity<?> update(@RequestBody UserPatient userPatient, @PathVariable Integer userPatientId) {
        try {
            UserPatient auxUserPatient = userPatientService.getByUserPatientId(userPatientId);
            userPatient.setUserPatientId(auxUserPatient.getUserPatientId());
            userPatientService.save(userPatient);
            return new ResponseEntity<String>("Updated record", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<String>("The record with the control number provided is not found in the database", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{userPatientId}")
    public void delete(@PathVariable Integer userPatientId) {
        userPatientService.delete(userPatientId);
    }

}
