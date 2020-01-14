/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.controllers;

import javax.validation.Valid;


import com.mycompany.model.entities.Auteur;
import com.mycompany.rest.dto.AuteurDto;
import com.mycompany.services.AuteurService;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author salima
 */
@RestController()
public class AuteurController {
    @Autowired 
    private AuteurService auteurService; 
    
    @Autowired
    private ModelMapper modelMapper;
	
	
/** GEt **/
    @GetMapping("/auteurs/{id}")
	public Object getAuteur(@PathVariable("id") Long id) {
	    Auteur auteur = auteurService.findById(id);
	    AuteurDto auteurDto = modelMapper.map(auteur, AuteurDto.class);
	    return ResponseEntity.status(HttpStatus.OK).body(auteurDto);
        }
    @GetMapping("/auteurs")
	    public Object AllAuteur() {
	        Set<Auteur> auteurs = auteurService.getAllAuteur();
	        java.lang.reflect.Type setType = new TypeToken<Set<AuteurDto>>() {
	        }.getType();
	        Set<AuteurDto> auteurDtos = modelMapper.map(auteurs, setType);
	        return ResponseEntity.status(HttpStatus.OK).body(auteurDtos);
	    }
            
    /**save**/ 
	 @PostMapping("/auteurs")
	    public Object addAuteur(@Valid @RequestBody AuteurDto auteurDto) {
	        Auteur auteur = modelMapper.map(auteurDto, Auteur.class);
	        auteur = auteurService.saveAuteur(auteur);
	        auteurDto = modelMapper.map(auteur, AuteurDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(auteurDto);
	    }
	 
	 /**delete**/
	   @DeleteMapping("/auteurs/{id}")
	    public Object DeleteAuteurs(@PathVariable("id") Long id) {
	        auteurService.deleteAuteur(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }
	  /**update**/ 
	   @PutMapping("/auteurs/{id}")
	    public Object updateAuteur(@Valid @RequestBody AuteurDto auteurDto, @PathVariable("id") Long id) {
	        Auteur auteur = modelMapper.map(auteurDto, Auteur.class);
	        auteur = auteurService.updateAuteur(id, auteur);
	        auteurDto = modelMapper.map(auteur, AuteurDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(auteurDto);
	    }        
}
