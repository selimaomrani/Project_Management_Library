/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.Impl;

import com.mycompany.dal.BibliothequeRepository;
import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.services.BibliothequeService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author salima
 */
@Service
public class BibliothequeServiceImpl implements BibliothequeService
{
@Autowired
    private BibliothequeRepository biblioRepository;
    @Autowired
    private BibliothequeService biblioService;
    @Override
    public Bibliotheque findById(Long id) {

         Bibliotheque bib =biblioRepository.findById(id).get();
         if (bib == null) {
	            System.out.println("erreur get");
	        }
	        return bib;    }

    @Override
    public Set<Bibliotheque> getAllBibliotheque() {

      return (Set<Bibliotheque>) biblioRepository.findAll();
    }

    @Override
    public Bibliotheque saveBibliotheque(Bibliotheque bibliotheque) {
         return biblioRepository.save(bibliotheque);

    }

    @Override
    public Bibliotheque updateBibliotheque(Long id, Bibliotheque bibliotheque) {
        findById(id);
	bibliotheque.setIdBibliotheque(id);
	return saveBibliotheque(bibliotheque);
    }

    @Override
    public void deleteBibliotheque(Long id) {
        try {
	        biblioRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("erreur delete");
	        }
    }
    
}
