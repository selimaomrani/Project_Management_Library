/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.controllers;

import com.mycompany.model.entities.Emprunt;
import com.mycompany.model.entities.Lecteur;
import com.mycompany.model.entities.Livres;
import com.mycompany.rest.dto.EmpruntDto;
import com.mycompany.services.EmpruntService;
import com.mycompany.services.LecteurService;
import com.mycompany.services.LivresService;
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
public class EmpruntController {
    @Autowired
    EmpruntService empruntService ;
    
    @Autowired
    LivresService livreService ;
    
    @Autowired
    LecteurService lecteurService;
    
    @Autowired
    private ModelMapper modelMapper;
    
     @GetMapping("/emprunts/{id}")
	    public Object getEmprunt(@PathVariable("id") Long id) {
	        Emprunt emprunt = empruntService.findById(id);
	        EmpruntDto empruntDto = modelMapper.map(emprunt, EmpruntDto.class);
	        return ResponseEntity.status(HttpStatus.OK).body(empruntDto);
            }
            
    @GetMapping("/livre/{idO}/emprunts")
    public Object EmpruntLivreList(@PathVariable("idO") Long idO) {
        Set<Emprunt> emprunts = empruntService.getAllLivresEmprunt(idO);
        Type setType = new TypeToken<Set<EmpruntDto>>() {
        }.getType();
        Set <EmpruntDto> empruntDtos = modelMapper.map(emprunts, setType);
        return ResponseEntity.status(HttpStatus.OK).body(empruntDtos);
    }
    
    @GetMapping("/lecteur/{idO}/emprunts")
    public Object EmpruntLecteurList(@PathVariable("idO") Long idO) {
        Set<Emprunt> emprunts = empruntService.getAllLecteurEmprunt(idO);
        Type setType = new TypeToken<Set<EmpruntDto>>() {
        }.getType();
        Set <EmpruntDto> empruntDtos = modelMapper.map(emprunts, setType);
        return ResponseEntity.status(HttpStatus.OK).body(empruntDtos);
    }
    
     @PostMapping("/livre/{idLivre}/lecteur/{idLecteur}/emprunts")
	    public Object addEmprunt(@PathVariable("idLivre") Long idLivre,@PathVariable("idLecteur") Long idLecteur, @Valid @RequestBody EmpruntDto empruntDto) {
	        Livres livre = livreService.findById(idLivre);
                Lecteur lecteur = lecteurService.findById(idLecteur);
	        Emprunt emprunt = modelMapper.map(empruntDto, Emprunt.class);
	        emprunt = empruntService.saveEmprunt(emprunt, livre ,lecteur);
	        empruntDto = modelMapper.map(emprunt, EmpruntDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(empruntDto);
	    }
     @PutMapping("/livre/{idLivre}/lecteur/{idLecteur}/emprunts/{id}")
	    public Object updateEmpruntOffre(@Valid @RequestBody EmpruntDto empruntDto, @PathVariable("id") Long id, @PathVariable("idLivre") Long idLivre,@PathVariable("idLecteur") Long idLecteur) {
	        Livres livre = livreService.findById(idLivre);
                Lecteur lecteur = lecteurService.findById(idLecteur);
	        Emprunt emprunt = modelMapper.map(empruntDto, Emprunt.class);
	        emprunt = empruntService.updateEmprunt(id,livre,lecteur, emprunt);
	        empruntDto = modelMapper.map(emprunt, EmpruntDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(empruntDto);
	    }
	  
    
    /**delete  **/
	   @DeleteMapping("/emprunts/{id}")
	    public Object DeleteEmprunts(@PathVariable("id") Long id) {
	        empruntService.deleteEmprunt(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }
}
