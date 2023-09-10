package com.example.demo.service;


import com.example.demo.dto.PersonneDTO;
import com.example.demo.erreur.ErreurPersonneException;
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

    /**
     *  En registrer une personne
     * @param personneDTO
     * @return
     * @throws ErreurPersonneException
     */
    @Override
    public PersonneDTO save(PersonneDTO personneDTO) throws ErreurPersonneException {
        if (Objects.nonNull(personneDTO) && Objects.nonNull(personneDTO.getDateNaissance())
                && (calculateAge(personneDTO.getDateNaissance()) <= 150)){
            Personne savedPersonne = repositoryPersonne.save(PersonneDTO.toEntity(personneDTO));
            return PersonneDTO.fromEntity(savedPersonne);

        }
        throw new ErreurPersonneException("Age superieur a 150 ans");
    }


    /**
     *
     * @param dateOfBirth
     * @return calculer l'age
     */
    public int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }

    /**
     * List des personnes
     * @return
     */

    public List<PersonneDTO> getAllPersonnes() {
        var sortList = new ArrayList<PersonneDTO>();
        repositoryPersonne.findAllByOrderByNomAndPrenom().forEach(personne -> sortList.add(PersonneDTO.fromEntity(personne)));
        return sortList;
    }
}
