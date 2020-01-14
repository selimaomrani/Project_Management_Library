/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.model.entities.Emprunt;
import com.mycompany.model.entities.Lecteur;
import com.mycompany.model.entities.Livres;
import java.util.Set;

/**
 *
 * @author salima
 */
public interface EmpruntService {
    
    Emprunt findById(Long id);
    
    Set <Emprunt> getAllLivresEmprunt(Long idlivre);
    Set <Emprunt> getAllLecteurEmprunt(Long idlecteur);
    
    Emprunt saveEmprunt(Emprunt emprunt,Livres livres,Lecteur lecteur);
    Emprunt updateEmprunt(Long id,Livres livres,Lecteur lecteur,Emprunt emprunt);
    
    void deleteEmprunt(Long id);
    
}
