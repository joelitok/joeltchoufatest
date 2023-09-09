package com.example.demo.erreur;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ExceptionHandle {

    public static final String AGE_SUPERIEUR_A_150 = "Age superieur a 150";

    @ExceptionHandler(ErreurPersonneException.class)
    public ResponseEntity<ErreurMessage> handleException() {
        final HttpStatus notSave = HttpStatus.INTERNAL_SERVER_ERROR;
        final ErreurMessage erreur = ErreurMessage.builder()
                .status(500)
                .message(AGE_SUPERIEUR_A_150)
                .timestamp(LocalDate.now())
                .build();
        return new ResponseEntity<>(erreur, notSave);
    }
}
