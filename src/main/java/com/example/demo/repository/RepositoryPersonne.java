package com.example.demo.repository;

import com.example.demo.dto.PersonneDTO;
import com.example.demo.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories()
public interface RepositoryPersonne extends JpaRepository<Personne, Long> {
    @Query("SELECT p FROM Personne p ORDER BY p.nom, p.prenom")
    List<Personne> findAllByOrderByNomAndPrenom();
}
