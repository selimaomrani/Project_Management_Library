
package com.mycompany.model.entities;

import com.mycompany.model.enumeration.Genres;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="lecteur")
public class Lecteur implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Lecteur")
    private Long idLecteur;
    
    @Column(name = "nom_Lecteur", length = 100)
    private String nomLecteur;
 
    @Column(name = "prenom_Lecteur", length = 100)
    private String prenomLecteur;
    
    @Column(name = "adresse", length = 100)
    private String adresse;
    
    @Column(name ="tel")
    private Long telephone; 
    
    @Column(name = "mail", length = 100)
    private String mail;
    
    @OneToMany(mappedBy= "lecteur")
    private Set <Emprunt> emprunts;
    
    @ManyToOne
    private Bibliotheque bib ;
    
    public Lecteur(){}
    
    

    public Long getIdLecteur() {
        return idLecteur;
    }

    public void setIdLecteur(Long id) {
        this.idLecteur = id;
    }
    	
    public String getNomLecteur(){
        return nomLecteur;
    }
    public void setNomLecteur(String nomLecteur){
        this.nomLecteur=nomLecteur;
    
    }
    
    
    public String getPrenomLecteur(){
        return prenomLecteur;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public Bibliotheque getBib() {
        return bib;
    }

    public void setBib(Bibliotheque bib) {
        this.bib = bib;
    }
    public void setPrenomLecteur(String prenomLecteur){
        this.prenomLecteur=prenomLecteur;
                
    }
    
    public String getAdresse(){
        return adresse;
    }
    public void setAdresse(String adresse){
        this.adresse=adresse;
                
    }
    
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail=mail;
                
    }
    
    public Long getTelephone(){
        return telephone ;
    }
    
    public void setTelephone(Long telephone){
        this.telephone=telephone;
    }
    

    
}
