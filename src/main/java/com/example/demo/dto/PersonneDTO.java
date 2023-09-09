package com.example.demo.dto;

import com.example.demo.model.Personne;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Builder
@Data
public class PersonneDTO {

    private Long id;

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    @JsonCreator
    public static PersonneDTO fromEntity(Personne personne){
        if (personne == null){
            return null;
        }
        return PersonneDTO.builder()
                .id(personne.getId())
                .nom(personne.getNom())
                .prenom(personne.getPrenom())
                .dateNaissance(personne.getDateNaissance())
                .build();
    }

    public static Personne toEntity(PersonneDTO personneDTO){
        if (personneDTO == null){
            return null;
        }
        Personne personne = new Personne();
        personne.setId(personneDTO.getId());
        personne.setNom(personneDTO.getNom());
        personne.setPrenom(personneDTO.getPrenom());
        personne.setDateNaissance(personneDTO.getDateNaissance());

        return personne;

    }

}
