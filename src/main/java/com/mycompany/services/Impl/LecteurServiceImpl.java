/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.Impl;

import com.mycompany.dal.LecteurRepository;
import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.model.entities.Lecteur;
import com.mycompany.services.BibliothequeService;
import com.mycompany.services.LecteurService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author salima
 */
@Service
public class LecteurServiceImpl implements LecteurService{
    @Autowired
    private LecteurRepository lecteurRepository;
    @Autowired
    private LecteurService lecteurService;
    @Autowired 
    private BibliothequeService bibService;

    @Override
    public Lecteur findById(Long id) {
        Lecteur lecteur =lecteurRepository.findById(id).get();
         if (lecteur == null) {
	            System.out.println("erreur get");
	        }
	        return lecteur;    
    }

    @Override
    public Set<Lecteur> getAllBiblioLecteur(Long idb) {
        Bibliotheque biblio = bibService.findById(idb);
        return (Set<Lecteur>) lecteurRepository.findByBibliotheque(biblio);
    }

    @Override
    public Lecteur saveLecteurBiblio(Lecteur lecteur, Bibliotheque bibliotheque) {
        lecteur.setBib(bibliotheque);
               
	return lecteurRepository.save(lecteur);
    }

    @Override
    public Lecteur updateLecteurBiblio(Long id, Lecteur lecteur, Bibliotheque bibliotheque) {
        findById(id);
	lecteur.setIdLecteur(id);
	lecteur.setBib(bibliotheque);
        return saveLecteurBiblio(lecteur,bibliotheque);
    }

    @Override
    public void deleteLecteur(Long id) {
        try {
            lecteurRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
            System.out.println("erreur delete");
		}
    }
    
}
