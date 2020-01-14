/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.entities;

import com.mycompany.model.enumeration.Genres;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;


@Entity
@Table(name="livres")
public class Livres implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Livres")
    private Long idLivres;
    
    @Column(name = "nom_Livres")
    private String nomLivres;
    
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genres genre;
    
    @Column(name= "nb_Exemplaires")
    private Integer nbExemplaires;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bib_id")
    private Bibliotheque bib;
    
    @OneToMany(mappedBy= "livres")
    private Set <Emprunt> emprunts;
 
    public Livres(){}
    
    public Long getIdLivres() {
        return idLivres;
    }

    public void setIdLivres(Long id) {
        this.idLivres = id;
    }
    	
    public String getNomLivres(){
        return nomLivres;
    }
    public void setNomLecteur(String nomLivres){
        this.nomLivres=nomLivres;
    
    }

    public Bibliotheque getBib() {
        return bib;
    }

    public void setBib(Bibliotheque bib) {
        this.bib = bib;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
    
    
    public Genres getGenre(){
        return genre;
    }
    
    public void setGenre(Genres genre){
        this.genre=genre;
    }
    
    public Integer getNbExemplaires(){
        return nbExemplaires ; 
    }
    
    public void setNbExemplaires (Integer nbExemplaires){
        this.nbExemplaires=nbExemplaires;
    }
    
    public Auteur getAuteur(){
        return auteur;
    }
    
    public void setAuteur(Auteur auteur){
        this.auteur=auteur ; 
    }
    
}
