package com.example.demo.erreur;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(ErreurPersonneException.class)
    public ResponseEntity<ErreurMessage> handleException(ErreurPersonneException exception) {
        final HttpStatus notSave = HttpStatus.INTERNAL_SERVER_ERROR;
        final ErreurMessage erreur = ErreurMessage.builder()
                .status(500)
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(erreur, notSave);
    }
}
