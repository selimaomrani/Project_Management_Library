package com.mycompany.model.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="emprunt")

public class Emprunt implements Serializable   {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Emprunt")
    private Long idEmprunt;

    public Long getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(Long idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    public Livres getLivres() {
        return livres;
    }

    public void setLivres(Livres livres) {
        this.livres = livres;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idEmprunt);
        hash = 67 * hash + Objects.hashCode(this.dateSortie);
        hash = 67 * hash + Objects.hashCode(this.dateRetour);
        hash = 67 * hash + Objects.hashCode(this.lecteur);
        hash = 67 * hash + Objects.hashCode(this.livres);
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
        final Emprunt other = (Emprunt) obj;
        if (!Objects.equals(this.idEmprunt, other.idEmprunt)) {
            return false;
        }
        if (!Objects.equals(this.dateSortie, other.dateSortie)) {
            return false;
        }
        if (!Objects.equals(this.dateRetour, other.dateRetour)) {
            return false;
        }
        if (!Objects.equals(this.lecteur, other.lecteur)) {
            return false;
        }
        if (!Objects.equals(this.livres, other.livres)) {
            return false;
        }
        return true;
    }
    
    @Column(name ="date_Sortie ")
    @Temporal(TemporalType.DATE)
    private Date dateSortie ;
    
    @Column(name ="date_Retour ")
    @Temporal(TemporalType.DATE)
    private  Date dateRetour;
     
     
    @ManyToOne
    @JoinColumn
    private Lecteur lecteur;
    
    @ManyToOne
    @JoinColumn
    private Livres livres;
    
}
