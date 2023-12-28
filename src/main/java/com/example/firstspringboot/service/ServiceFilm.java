package com.example.firstspringboot.service;

import com.example.firstspringboot.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.firstspringboot.repository.FilmRepository;

import java.util.List;

@Service
public class ServiceFilm implements IServiceFilm{
    @Autowired
    FilmRepository filmRepository;
    @Override
    public Film createFilm(Film f) {
        return filmRepository.save(f);
    }

    @Override
    public Film findFilmById(int id) {
        return filmRepository.findById(id).get();
    }

    @Override
    public Film updateFilm(Film f) {
        return filmRepository.save(f);
    }

    @Override
    public List<Film> findAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public void deleteFilm(int id) {
         filmRepository.deleteById(id);
    }

    @Override
    public Boolean filmExist(int id){
        return filmRepository.existsById(id);
    }

    @Override
    public List<Film> findFilmByAnnee(int annee) {
        return filmRepository.findAllByAnneeparutionOrderByAnneeparution(annee);
    }
}
