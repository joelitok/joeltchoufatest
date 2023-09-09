package com.tchoufa.services;

import com.tchoufa.erreur.ErreurPersonneException;
import com.tchoufa.doa.RepositoryPersonne;
import com.tchoufa.model.Personne;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ServicePersonne {
    public RepositoryPersonne repositoryPersonne;

    public Personne savePersonne(Personne personne) throws ErreurPersonneException {
        if (Objects.nonNull(personne) && Objects.nonNull(personne.getDateNaissance())
                && calculateAge(personne.getDateNaissance()) <= 150) {
            return repositoryPersonne.save(personne);
        }
        throw new ErreurPersonneException("Age superieur a 150 ");
    }

    public int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }


    public List<Personne> getAllPersonnes() {
        return repositoryPersonne.findAllByOrderByNomAndPrenom();

    }


}
