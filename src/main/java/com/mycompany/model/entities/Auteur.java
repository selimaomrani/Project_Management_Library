/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="auteur")
public class Auteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Auteur")
    private Long idAuteur;
    
     
    @Column(name = "nom_Auteur", length = 100)
    private String nomAuteur;
 
    @Column(name = "prenom_Auteur", length = 100)
    private String prenomAuteur;
    
    @OneToMany(mappedBy= "auteur")
    private Set <Livres> livres;
  
    public Auteur(){}
    
    public Long getId() {
        return idAuteur;
    }
    public void setId(Long id) {
        this.idAuteur = id;
    }
    
    public String getNomAuteur(){
        return nomAuteur;
    }
    public void setNomAuteur(String nomAuteur){
        this.nomAuteur=nomAuteur;
    }
    
    public String getPrenomAuteur(){
        return prenomAuteur;
    }
    public void setPrenomAuteur(String prenomAuteur){
        this.prenomAuteur=prenomAuteur;
    }
    
    
    
}
