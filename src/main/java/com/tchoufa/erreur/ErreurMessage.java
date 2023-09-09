package com.tchoufa.erreur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class ErreurMessage {
    private  int status;
    private Date  timestamp;
    private  String message;

}
