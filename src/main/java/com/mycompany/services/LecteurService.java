/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.model.entities.Lecteur;

import java.util.Set;

/**
 *
 * @author salima
 */
public interface LecteurService {
    
    Lecteur findById(Long id);
    Set <Lecteur> getAllBiblioLecteur(Long idb);
    Lecteur saveLecteurBiblio(Lecteur lecteur,Bibliotheque bibliotheque);
    Lecteur updateLecteurBiblio(Long id,Lecteur lecteur, Bibliotheque bibliotheque);
    void deleteLecteur(Long id);
    
    
}
