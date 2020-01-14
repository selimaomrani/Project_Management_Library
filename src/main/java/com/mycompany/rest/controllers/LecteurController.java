/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.controllers;

import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.model.entities.Lecteur;
import com.mycompany.rest.dto.LecteurDto;
import com.mycompany.services.BibliothequeService;
import com.mycompany.services.LecteurService;
import java.lang.reflect.Type;
import java.util.Set;
import javax.validation.Valid;
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
public class LecteurController {
    @Autowired
	private LecteurService lecteurService;
	@Autowired
    private BibliothequeService bibliothequeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
/** GEt **/
	 @GetMapping("/lecteurs/{id}")
	    public Object getLecteur(@PathVariable("id") Long id) {
	        Lecteur lecteur = lecteurService.findById(id);
	        LecteurDto lecteurDto = modelMapper.map(lecteur, LecteurDto.class);
	        return ResponseEntity.status(HttpStatus.OK).body(lecteurDto);
			
	        
	    }
	
	@GetMapping("/bibliotheque/{idO}/lecteurs")
    public Object LecteurBibliothequeList(@PathVariable("idO") Long idO) {
        Set<Lecteur> lecteurs = lecteurService.getAllBiblioLecteur(idO);
        Type setType = new TypeToken<Set<LecteurDto>>() {
        }.getType();
        Set<LecteurDto> lecteurDtos = modelMapper.map(lecteurs, setType);
        return ResponseEntity.status(HttpStatus.OK).body(lecteurDtos);
    }
	
	/** Save **/ 
	  @PostMapping("/bibliotheque/{idO}/lecteurs")
	    public Object addLecteurBibliotheque(@PathVariable("idO") Long idO, @Valid @RequestBody LecteurDto lecteurDto) {
	        Bibliotheque bibliotheque = bibliothequeService.findById(idO);
	        Lecteur lecteur = modelMapper.map(lecteurDto, Lecteur.class);
	        lecteur = lecteurService.saveLecteurBiblio(lecteur, bibliotheque);
	        lecteurDto = modelMapper.map(lecteur, LecteurDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(lecteurDto);
	    }
	/** update **/ 
	   @PutMapping("/bibliotheque/{idO}/lecteurs/{id}")
	    public Object updateLecteurBibliotheque(@Valid @RequestBody LecteurDto lecteurDto, @PathVariable("id") Long id, @PathVariable("idO") Long idO) {
	        Bibliotheque bibliotheque = bibliothequeService.findById(idO);
	        Lecteur lecteur = modelMapper.map(lecteurDto, Lecteur.class);
	        lecteur = lecteurService.updateLecteurBiblio(id, lecteur, bibliotheque);
	        lecteurDto = modelMapper.map(lecteur, LecteurDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(lecteurDto);
	    }
	  
	  
	/**delete  **/
	   @DeleteMapping("/lecteurs/{id}")
	    public Object DeleteLecteurs(@PathVariable("id") Long id) {
	        lecteurService.deleteLecteur(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }
	
}
