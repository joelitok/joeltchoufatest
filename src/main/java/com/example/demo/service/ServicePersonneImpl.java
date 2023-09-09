package com.example.demo.service;


import com.example.demo.dto.PersonneDTO;
import com.example.demo.model.Personne;
import com.example.demo.repository.RepositoryPersonne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ServicePersonneImpl implements ServicePersonne {
    private RepositoryPersonne repositoryPersonne;

    @Autowired
    public ServicePersonneImpl(RepositoryPersonne repositoryPersonne) {
        this.repositoryPersonne = repositoryPersonne;
    }

    @Override
    public PersonneDTO save(PersonneDTO personneDTO) {
        if (Objects.nonNull(personneDTO) && Objects.nonNull(personneDTO.getDateNaissance())
                && (calculateAge(personneDTO.getDateNaissance()) <= 150)){
            Personne savedPersonne = repositoryPersonne.save(PersonneDTO.toEntity(personneDTO));
            return PersonneDTO.fromEntity(savedPersonne);

        }
        throw new RuntimeException();
    }



    public int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }


    public List<PersonneDTO> getAllPersonnes() {
        var sortList = new ArrayList<PersonneDTO>();
        repositoryPersonne.findAllByOrderByNomAndPrenom().forEach(
                personne -> sortList.add(PersonneDTO.fromEntity(personne)) );
        return sortList;
    }
}
