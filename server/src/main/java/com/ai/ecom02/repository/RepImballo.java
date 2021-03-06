/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ai.ecom02.repository;

import com.ai.ecom02.model.Imballo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francesco
 */

@Repository
public interface RepImballo extends JpaRepository<Imballo, Long> {

    List<Imballo> findByDescrizioneLike(String descrizione);
    
//    List<Imballo> findByCostoLike(Double costo);
}
