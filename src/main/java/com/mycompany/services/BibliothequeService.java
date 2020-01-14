/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.model.entities.Bibliotheque;
import java.util.Set;


/**
 *
 * @author salima
 */
public interface BibliothequeService {
   
    Bibliotheque findById(Long id);
    Set<Bibliotheque> getAllBibliotheque();
    Bibliotheque saveBibliotheque(Bibliotheque bibliotheque);
    Bibliotheque updateBibliotheque(Long id,Bibliotheque bibliotheque );
    void deleteBibliotheque(Long id);
    
}
