package com.student.student_information_system.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (IllegalArgumentException.class)
    ResponseEntity<String> IllegalArgumentExceptionHandler(IllegalArgumentException e) {
    return ResponseEntity.badRequest().body(e.getMessage());
    }
    
    @ExceptionHandler
    ResponseEntity<String> RepositoryExceptionHandler(final RepositoryException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }
 }
