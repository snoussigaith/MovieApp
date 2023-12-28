package com.example.firstspringboot.controller;

import com.example.firstspringboot.entities.Film;
import com.example.firstspringboot.handler.FilmNotFoundException;
import com.example.firstspringboot.service.IServiceFilm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")

public class FilmRestController {

    @Autowired
    IServiceFilm iServiceFilm;



    @GetMapping("")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    @JsonIgnore
    public List<Film> getAll(){
        return iServiceFilm.findAllFilms();
    }

    @GetMapping("{id}")
    public Film getparid(@PathVariable("id") int id){

        if(!iServiceFilm.filmExist(id))
            throw new FilmNotFoundException();
        return iServiceFilm.findFilmById(id);
    }

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("add")
    public Film addFilm(@RequestBody Film film){
        return iServiceFilm.createFilm(film);
    }


    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("{id}")
    public String deleteFilm(@PathVariable("id") int id){
        if(!iServiceFilm.filmExist(id))
            throw new FilmNotFoundException();
        iServiceFilm.deleteFilm(id);
        return "le film est supprimer ";
    }


    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("update")
    public Film updateFilm(@RequestBody Film film){
        if(!iServiceFilm.filmExist(film.getId()))
            throw new FilmNotFoundException();
        Film updatedFilm=iServiceFilm.findFilmById(film.getId());
        updatedFilm.setActeurs(film.getActeurs());
        updatedFilm.setCategorie(film.getCategorie());
        updatedFilm.setTitre(film.getTitre());
        updatedFilm.setDescription(film.getDescription());
        updatedFilm.setAnneeparution(film.getAnneeparution());
        return iServiceFilm.updateFilm(updatedFilm);
    }


    @GetMapping("annee/{annee}")
    public List<Film> getFilmByannee(@PathVariable int annee){
        return iServiceFilm.findFilmByAnnee(annee);
    }

}
