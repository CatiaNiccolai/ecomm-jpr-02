/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ai.ecom02.controller;

import com.ai.ecom02.model.Categoria;
import com.ai.ecom02.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ControllerCategoria {
    
    @Autowired
    CategoriaService categoriaService;
    
    @RequestMapping(value={"/aggiungi-categoria"})
    @ResponseBody
    public List<Categoria> aggiungiContatto(
            @RequestBody Categoria categoria
    ){
        categoriaService.addCategoria(categoria); 
        return categoriaService.getLista();
    }
    
    @RequestMapping(value={"/lista-categorie"})
    @ResponseBody
    public List<Categoria> listaContatti(){
        return categoriaService.getLista();
    }
    
    @RequestMapping(value={"/rimuovi-categoria"})
    @ResponseBody
    public List<Categoria> rimuoviCategoria(
            @RequestBody Categoria categoria
    ){
        return null;
    }
}
