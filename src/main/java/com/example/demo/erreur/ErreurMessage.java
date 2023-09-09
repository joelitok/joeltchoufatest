package com.example.demo.erreur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class ErreurMessage {
    private  int status;
    private LocalDate  timestamp;
    private  String message;

}
