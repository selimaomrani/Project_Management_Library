/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Collection;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author salima
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class BibliothequeDto {
      
   
    private Long idBibliotheque;
    private String nomBibliotheque;
    private String adresseBibliotheque;
    private Collection <LivreDto> livreDtos;
    private Collection <LecteurDto> lecteurDtos;
}
