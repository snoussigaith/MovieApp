package com.example.firstspringboot.service;
import com.example.firstspringboot.entities.Film;
import java.util.List;
public interface IServiceFilm {
    public Film createFilm(Film f);
    public Film findFilmById(int id);
    public Film updateFilm(Film f);
    public List<Film> findAllFilms();
    public void deleteFilm(int id);
    public Boolean filmExist(int id);

    public List<Film> findFilmByAnnee(int annee);
}
