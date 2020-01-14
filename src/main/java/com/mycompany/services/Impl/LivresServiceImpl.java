/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.Impl;

import com.mycompany.dal.LivresRepository;
import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.model.entities.Livres;
import com.mycompany.services.BibliothequeService;
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
public class LivresServiceImpl implements LivresService {
    @Autowired
    private LivresRepository livresRepository; 
    
    @Autowired 
    private LivresService livresService; 
    
    @Autowired private BibliothequeService bibService;
    

    @Override
    public Livres findById(Long id) {
        Livres livres =livresRepository.findById(id).get();
         if (livres == null) {
	            System.out.println("erreur get");
	        }
	        return livres; 
        
    }

    @Override
    public Set<Livres> getAllBiblioLivres(Long idb) {
          Bibliotheque biblio = bibService.findById(idb);
        return (Set<Livres>) livresRepository.findByBibliotheque(biblio);
    }

    @Override
    public Livres saveLivresBiblio(Livres livres, Bibliotheque bibliotheque) {
         livres.setBib(bibliotheque);
               
	return livresRepository.save(livres);
    }

    @Override
    public Livres updateLivresBiblio(Long id, Livres livres, Bibliotheque bibliotheque) {
        findById(id);
	livres.setIdLivres(id);
        livres.setBib(bibliotheque);
        return saveLivresBiblio(livres,bibliotheque);
    }

    @Override
    public void deleteLivres(Long id) {
         try {
            livresRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
            System.out.println("erreur delete");
		}
    }
    
}
