package com.example.demo.service;

import com.example.demo.dto.PersonneDTO;
import com.example.demo.erreur.ErreurPersonneException;
import com.example.demo.model.Personne;

import java.util.List;

public interface ServicePersonne {
    PersonneDTO save(PersonneDTO dto) throws ErreurPersonneException;
    List<PersonneDTO> getAllPersonnes();
}
