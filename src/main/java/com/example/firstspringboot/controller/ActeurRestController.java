package com.example.firstspringboot.controller;

import com.example.firstspringboot.entities.Acteur;
import com.example.firstspringboot.entities.Film;
import com.example.firstspringboot.handler.FilmNotFoundException;
import com.example.firstspringboot.service.IServiceActeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acteur")
public class ActeurRestController {

    @Autowired
    IServiceActeur iServiceActeur;

    @GetMapping("")
    public List<Acteur> getall(){
        return iServiceActeur.findAllActeur();
    }

    @GetMapping("{id}")
    public Acteur getActeur(@PathVariable int id ){
            if(!iServiceActeur.acteurExist(id))
                throw new FilmNotFoundException();
        return iServiceActeur.findActeurById(id);
    }

    @PostMapping("add")
    public Acteur addActeur(@RequestBody Acteur acteur){
        return iServiceActeur.createActeur(acteur);
    }

    @DeleteMapping("{id}")
    public String deleteActeur(@PathVariable("id") int id){
        iServiceActeur.deleteActeur(id);
        return "le acteur est supprimer";
    }

    @PutMapping("update")
    public Acteur updateActeur(@RequestBody Acteur acteur){
        Acteur updateActeur=iServiceActeur.findActeurById(acteur.getId());
        updateActeur.setNom(acteur.getNom());
        updateActeur.setPrenom(acteur.getPrenom());
        return iServiceActeur.updateActeur(updateActeur);

    }


}
