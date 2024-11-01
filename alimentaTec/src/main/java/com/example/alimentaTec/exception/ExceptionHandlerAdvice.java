package com.example.alimentaTec.exception;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleException(NoSuchElementException e) {
        return  new ResponseEntity<>("The requested item is not registered", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleException(DataIntegrityViolationException e) {
        return new ResponseEntity<>("some of the columns are not well defined",HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>("The request body is not well defined",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleException(EntityNotFoundException e) {
        return new ResponseEntity<>("The requested item is not registered",HttpStatus.NOT_FOUND);
    }
    @SuppressWarnings("null")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>("Validation error: " + e.getBindingResult().getFieldError().getDefaultMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Invalid argument: " + e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}