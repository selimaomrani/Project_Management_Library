/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class AuteurDto {
     private Long idAuteur;
    private String nomAuteur;
    private String prenomAuteur;
    private Collection <LivreDto> livreDtos;
}
