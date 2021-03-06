/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ai.ecom02.controller;

import com.ai.ecom02.dto.RicercaDto;
import com.ai.ecom02.model.Spedizione;
import com.ai.ecom02.service.SpedizioneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roberto
 */
@CrossOrigin("*")
@RestController
public class SpedizioneController {
    
    @Autowired
    SpedizioneService spedizioneService;
    
    @RequestMapping(value={"/aggiungi-spedizione"})
    @ResponseBody
    public List<Spedizione> aggiungiSpedizione(
            @RequestBody Spedizione spedizione
    ){
        spedizioneService.addSped(spedizione);
        return spedizioneService.getLista();
    }
    
    @RequestMapping(value={"/lista-spedizioni"})
    @ResponseBody
    public List<Spedizione> listaSpedizioni(){
        return spedizioneService.getLista();
    }
    
    @RequestMapping(value={"/rimuovi-spedizione/{id}"})
    @ResponseBody
    public List<Spedizione> rimuoviSpedizione(
        @PathVariable Long id
    ){
        spedizioneService.removeSped(id);
        return spedizioneService.getLista();
    }
    
    @RequestMapping(value={"/cerca-spedizione"})
    @ResponseBody
    public List<Spedizione> cercaSpedizione(
            @RequestBody String ricerca
    ){
        return spedizioneService.findSped(ricerca, ricerca);
    }
    
    @RequestMapping(value={"/modifica-spedizione"})
    @ResponseBody
    public List<Spedizione> modificaCategoria(
            @RequestBody Spedizione spedizione
    ){
        spedizioneService.updateSped(spedizione);
        return spedizioneService.getLista();
    }
}
