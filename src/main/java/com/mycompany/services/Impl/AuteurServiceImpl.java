/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.Impl;

import com.mycompany.dal.AuteurRepository;
import com.mycompany.model.entities.Auteur;
import com.mycompany.services.AuteurService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author salima
 */
@Service
public class AuteurServiceImpl implements AuteurService{
    
    @Autowired
    private AuteurRepository auteurRepository;
    @Autowired
    private AuteurService auteurService;

    @Override
    public Auteur findById(Long id) {
         Auteur auteur =auteurRepository.findById(id).get();
         if (auteur == null) {
	            System.out.println("erreur get");
	        }
	        return auteur;
    }

    @Override
    public Set<Auteur> getAllAuteur() {
      return (Set<Auteur>) auteurRepository.findAll();
   
    
    }

    @Override
    public Auteur saveAuteur(Auteur auteur) {
         return auteurRepository.save(auteur);
    }

    @Override
    public Auteur updateAuteur(Long id, Auteur auteur) {
        findById(id);
	auteur.setId(id);
	return saveAuteur(auteur);
    }

    @Override
    public void deleteAuteur(Long id) {
         try {
	        auteurRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("erreur delete");
	        }
    }
    
}
