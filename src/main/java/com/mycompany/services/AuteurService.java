/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.model.entities.Auteur;
import java.util.Set;

/**
 *
 * @author salima
 */
public interface AuteurService {
    Auteur findById(Long id);
    Set<Auteur> getAllAuteur();
    Auteur saveAuteur(Auteur bibliotheque);
    Auteur updateAuteur(Long id,Auteur bibliotheque );
    void deleteAuteur(Long id);
    
}
