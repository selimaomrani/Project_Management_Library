/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.controllers;

import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.model.entities.Livres;
import com.mycompany.rest.dto.LivreDto;
import com.mycompany.services.BibliothequeService;
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
public class LivresController {
    @Autowired
	private LivresService livreService;
	@Autowired
    private BibliothequeService bibliothequeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
/** GEt **/
	 @GetMapping("/livres/{id}")
	    public Object getLivre(@PathVariable("id") Long id) {
	        Livres livre = livreService.findById(id);
	        LivreDto livreDto = modelMapper.map(livre, LivreDto.class);
	        return ResponseEntity.status(HttpStatus.OK).body(livreDto);
			
	        
	    }
	
	@GetMapping("/bibliotheque/{idO}/livres")
    public Object LivreBibliothequeList(@PathVariable("idO") Long idO) {
        Set<Livres> livres = livreService.getAllBiblioLivres(idO);
        Type setType = new TypeToken<Set<LivreDto>>() {
        }.getType();
        Set<LivreDto> livreDtos = modelMapper.map(livres, setType);
        return ResponseEntity.status(HttpStatus.OK).body(livreDtos);
    }
	
	/** Save **/ 
	  @PostMapping("/bibliotheque/{idO}/livres")
	    public Object addLivreBibliotheque(@PathVariable("idO") Long idO, @Valid @RequestBody LivreDto livreDto) {
	        Bibliotheque bibliotheque = bibliothequeService.findById(idO);
	        Livres livre = modelMapper.map(livreDto, Livres.class);
	        livre = livreService.saveLivresBiblio(livre, bibliotheque);
	        livreDto = modelMapper.map(livre, LivreDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(livreDto);
	    }
	/** update **/ 
	   @PutMapping("/bibliotheque/{idO}/livres/{id}")
	    public Object updateLivreBibliotheque(@Valid @RequestBody LivreDto livreDto, @PathVariable("id") Long id, @PathVariable("idO") Long idO) {
	        Bibliotheque bibliotheque = bibliothequeService.findById(idO);
	        Livres livre = modelMapper.map(livreDto, Livres.class);
	        livre = livreService.updateLivresBiblio(id, livre, bibliotheque);
	        livreDto = modelMapper.map(livre, LivreDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(livreDto);
	    }
	  
	  
	/**delete  **/
	   @DeleteMapping("/livres/{id}")
	    public Object DeleteLivres(@PathVariable("id") Long id) {
	        livreService.deleteLivres(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }
	
    
}
