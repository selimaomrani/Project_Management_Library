/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mycompany.model.enumeration.Genres;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LivreDto {
     private Long idLivres;
    private String nomLivres;
    private Genres genre;
    private Integer nbExemplaires;
    
    private Collection <EmpruntDto> empruntDtos;
}
