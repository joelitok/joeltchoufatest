package com.example.demo.controller.api;

import com.example.demo.dto.PersonneDTO;
import com.example.demo.erreur.ErreurPersonneException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface PersonneApi {
    @PostMapping(value = "/personne/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PersonneDTO save(@RequestBody PersonneDTO dto) throws ErreurPersonneException;

    @GetMapping(value = "/personnes", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PersonneDTO> getAllPersonnes();
}