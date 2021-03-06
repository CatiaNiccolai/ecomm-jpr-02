/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ai.ecom02.service.impl;

import com.ai.ecom02.dto.RicercaDto;
import com.ai.ecom02.model.Spedizione;
import com.ai.ecom02.repository.RepSpedizione;
import com.ai.ecom02.service.SpedizioneService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Roberto
 */
@Service
public class SpedizioneServiceImpl implements SpedizioneService {

    @Autowired
    RepSpedizione repSpedizione;

    @Override
    public void addSped(Spedizione spedizione) {

        try {
            repSpedizione.save(spedizione);
        } catch (Exception ex) {

        }
    }

    @Override
    public List<Spedizione> getLista() {
        return repSpedizione.findAll();
    }

    @Override
    public List<Spedizione> removeSped(Long id) {
        repSpedizione.deleteById(id);
        return getLista();
    }

    @Override
    public List<Spedizione> findSped(String codice, String nome) {
        return repSpedizione.findByCodiceLikeOrNomeLike("%"+codice+"%", "%"+nome+"%");
    }

    @Override
    public List<Spedizione> updateSped(Spedizione spedizione) {

        try {
            repSpedizione.save(spedizione);
        } catch (Exception e) {

        }
        return getLista();
    }

}
