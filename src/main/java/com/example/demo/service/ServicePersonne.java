package com.example.demo.service;

import com.example.demo.dto.PersonneDTO;
import com.example.demo.model.Personne;

import java.util.List;

public interface ServicePersonne {
    PersonneDTO save(PersonneDTO dto);
    List<PersonneDTO> getAllPersonnes();
}
