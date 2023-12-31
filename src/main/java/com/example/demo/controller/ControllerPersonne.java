package com.example.demo.controller;

import com.example.demo.controller.api.PersonneApi;
import com.example.demo.dto.PersonneDTO;
import com.example.demo.erreur.ErreurPersonneException;
import com.example.demo.service.ServicePersonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerPersonne implements PersonneApi {

    @Autowired
    private ServicePersonne servicePersonne;


    @Override
    public PersonneDTO save(PersonneDTO dto) throws ErreurPersonneException {
        return servicePersonne.save(dto);
    }

    @Override
    public List<PersonneDTO> getAllPersonnes() {
        return servicePersonne.getAllPersonnes();
    }
}
