package com.mycompany.model.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bibliothecaire")
public class Bibliotheque implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Bibliotheque")
    private Long idBibliotheque;
    
    @Column(name = "nom_Bibliotheque", length = 100)
    private String nomBibliotheque;
 
    @Column(name = "adresse_Bibliotheque", length = 100)
    private String adresseBibliotheque;
    
    @OneToMany(mappedBy= "bib" , fetch = FetchType.LAZY)
    private Set <Livres> livres;
    
     @OneToMany(mappedBy= "bib" , fetch = FetchType.LAZY)
    private Set <Lecteur> lecteur;
    
    public Long getIdBibliotheque() {
        return idBibliotheque;
    }

    public void setIdBibliotheque(Long idBibliotheque) {
        this.idBibliotheque = idBibliotheque;
    }

    public String getNomBibliotheque() {
        return nomBibliotheque;
    }

    public void setNomBibliotheque(String nomBibliotheque) {
        this.nomBibliotheque = nomBibliotheque;
    }

    public String getAdresseBibliotheque() {
        return adresseBibliotheque;
    }

    public void setAdresseBibliotheque(String adresseBibliotheque) {
        this.adresseBibliotheque = adresseBibliotheque;
    }
    
    public  Bibliotheque(){}

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idBibliotheque);
        hash = 59 * hash + Objects.hashCode(this.nomBibliotheque);
        hash = 59 * hash + Objects.hashCode(this.adresseBibliotheque);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bibliotheque other = (Bibliotheque) obj;
        if (!Objects.equals(this.nomBibliotheque, other.nomBibliotheque)) {
            return false;
        }
        if (!Objects.equals(this.adresseBibliotheque, other.adresseBibliotheque)) {
            return false;
        }
        if (!Objects.equals(this.idBibliotheque, other.idBibliotheque)) {
            return false;
        }
        return true;
    }

  
    

    
    
    
}
