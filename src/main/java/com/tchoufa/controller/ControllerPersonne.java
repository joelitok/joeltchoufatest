package com.tchoufa.controller;


import com.tchoufa.erreur.ErreurPersonneException;
import com.tchoufa.model.Personne;
import com.tchoufa.services.ServicePersonne;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ControllerPersonne {
    public ServicePersonne servicePersonne;

    @PostMapping("/save")
    public ResponseEntity<Personne> savePersonne(@RequestBody Personne personne) throws ErreurPersonneException {
        log.info("save personne");
        return ResponseEntity.ok(servicePersonne.savePersonne(personne));
    }

    @PostMapping("/all")
    public ResponseEntity<List<Personne>> getPersonnes() {
        log.info("all personne");
        return ResponseEntity.ok(servicePersonne.getAllPersonnes());
    }
}
