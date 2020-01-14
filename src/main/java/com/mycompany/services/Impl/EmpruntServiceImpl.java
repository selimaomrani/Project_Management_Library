/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.Impl;

import com.mycompany.dal.EmpruntRepository;
import com.mycompany.model.entities.Emprunt;
import com.mycompany.model.entities.Lecteur;
import com.mycompany.model.entities.Livres;
import com.mycompany.services.EmpruntService;
import com.mycompany.services.LecteurService;
import com.mycompany.services.LivresService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author salima
 */
@Service
public class EmpruntServiceImpl implements EmpruntService{
    
    @Autowired
    private EmpruntRepository empruntRepository;
    
    @Autowired 
    private EmpruntService empruntService; 
    
    @Autowired 
    private LivresService livresService; 
    
    @Autowired 
    private LecteurService lecteurService ; 

    @Override
    public Emprunt findById(Long id) {
         Emprunt emprunt =empruntRepository.findById(id).get();
         if (emprunt == null) {
	            System.out.println("erreur get");
	        }
	        return emprunt; 
        
    }

    @Override
    public Set<Emprunt> getAllLivresEmprunt(Long idlivre) {
        Livres livres = livresService.findById(idlivre);
        return (Set<Emprunt>) empruntRepository.findByLivres(livres);
    }

    @Override
    public Set<Emprunt> getAllLecteurEmprunt(Long idlecteur) {
        Lecteur lecteur = lecteurService.findById(idlecteur);
        return (Set<Emprunt>) empruntRepository.findByLecteur(lecteur);
      
    }

    @Override
    public Emprunt saveEmprunt(Emprunt emprunt, Livres livres, Lecteur lecteur) {
        emprunt.setLivres(livres);
        emprunt.setLecteur(lecteur);
	return empruntRepository.save(emprunt);

    }

    @Override
    public Emprunt updateEmprunt(Long id, Livres livres, Lecteur lecteur, Emprunt emprunt) {
        findById(id);
	emprunt.setIdEmprunt(id);
        emprunt.setLivres(livres);
        emprunt.setLecteur(lecteur);
        return saveEmprunt(emprunt,livres,lecteur);
    }

    @Override
    public void deleteEmprunt(Long id) {
           try {
           empruntRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
            System.out.println("erreur delete");
		}
    }
    
}
