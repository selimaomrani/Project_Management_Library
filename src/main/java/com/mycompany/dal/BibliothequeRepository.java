/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dal;

import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.model.entities.Lecteur;
import com.mycompany.model.entities.Livres;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author salima
 */
@Repository
public interface BibliothequeRepository extends JpaRepository<Bibliotheque,Long> {
    Set <Bibliotheque> findByLivres (Livres livres);
    Set <Bibliotheque> findByLecteur (Lecteur lecteur);
}
