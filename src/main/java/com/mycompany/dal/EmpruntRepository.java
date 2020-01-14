/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dal;

import com.mycompany.model.entities.Emprunt;
import com.mycompany.model.entities.Lecteur;
import com.mycompany.model.entities.Livres;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author salima
 */
@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt,Long>{
    Set <Emprunt> findByLecteur(Lecteur lecteur);
    Set <Emprunt> findByLivres (Livres livre);

}
