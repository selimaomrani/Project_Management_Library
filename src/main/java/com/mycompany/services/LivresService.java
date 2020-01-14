/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.model.entities.Livres;
import java.util.Set;

/**
 *
 * @author salima
 */
public interface LivresService {
    
    Livres findById(Long id);
    Set <Livres> getAllBiblioLivres(Long idb);
    Livres saveLivresBiblio(Livres livres,Bibliotheque bibliotheque);
    Livres updateLivresBiblio(Long id,Livres livres, Bibliotheque bibliotheque);
    void deleteLivres(Long id);
    
}
