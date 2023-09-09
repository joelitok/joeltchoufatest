package com.tchoufa.doa;

import com.tchoufa.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RepositoryPersonne extends JpaRepository<Personne, Long> {
    @Query("SELECT p FROM Personne p ORDER BY p.nom, p.prenom")
    List<Personne> findAllByOrderByNomAndPrenom();
}
