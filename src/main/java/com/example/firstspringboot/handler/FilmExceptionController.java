package com.example.firstspringboot.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FilmExceptionController {

    @ExceptionHandler(value=FilmNotFoundException.class)
    public ResponseEntity<Object> exception(FilmNotFoundException exception){
        return new ResponseEntity<>("Film not found", HttpStatus.NOT_FOUND);
    }
}
