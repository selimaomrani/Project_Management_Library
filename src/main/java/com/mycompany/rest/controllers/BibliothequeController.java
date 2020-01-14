/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.controllers;

import com.mycompany.model.entities.Bibliotheque;
import com.mycompany.rest.dto.BibliothequeDto;
import com.mycompany.services.BibliothequeService;
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
public class BibliothequeController {
    @Autowired 
    private BibliothequeService bibliothequeService; 
    
    @Autowired
    private ModelMapper modelMapper;
	
	
/** GEt **/
    @GetMapping("/bibliotheques/{id}")
	public Object getBibliotheque(@PathVariable("id") Long id) {
	    Bibliotheque bibliotheque = bibliothequeService.findById(id);
	    BibliothequeDto bibliothequeDto = modelMapper.map(bibliotheque, BibliothequeDto.class);
	    return ResponseEntity.status(HttpStatus.OK).body(bibliothequeDto);
        }
    @GetMapping("/bibliotheques")
	    public Object AllBibliotheque() {
	        Set<Bibliotheque> bibliotheques = bibliothequeService.getAllBibliotheque();
	        java.lang.reflect.Type setType = new TypeToken<Set<BibliothequeDto>>() {
	        }.getType();
	        Set<BibliothequeDto> bibliothequeDtos = modelMapper.map(bibliotheques, setType);
	        return ResponseEntity.status(HttpStatus.OK).body(bibliothequeDtos);
	    }
            
    /**save**/ 
	 @PostMapping("/bibliotheques")
	    public Object addBibliotheque(@Valid @RequestBody BibliothequeDto bibliothequeDto) {
	        Bibliotheque bibliotheque = modelMapper.map(bibliothequeDto, Bibliotheque.class);
	        bibliotheque = bibliothequeService.saveBibliotheque(bibliotheque);
	        bibliothequeDto = modelMapper.map(bibliotheque, BibliothequeDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(bibliothequeDto);
	    }
	 
	 /**delete**/
	   @DeleteMapping("/bibliotheques/{id}")
	    public Object DeleteBibliotheques(@PathVariable("id") Long id) {
	        bibliothequeService.deleteBibliotheque(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }
	  /**update**/ 
	   @PutMapping("/bibliotheques/{id}")
	    public Object updateBibliotheque(@Valid @RequestBody BibliothequeDto bibliothequeDto, @PathVariable("id") Long id) {
	        Bibliotheque bibliotheque = modelMapper.map(bibliothequeDto, Bibliotheque.class);
	        bibliotheque = bibliothequeService.updateBibliotheque(id, bibliotheque);
	        bibliothequeDto = modelMapper.map(bibliotheque, BibliothequeDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(bibliothequeDto);
	    }        
}
