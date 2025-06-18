package com.fulldev.alunos.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ExeceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerNotFound(EntityNotFoundException e) {
        Map<String, String> body = Map.of("message", e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
