package com.example.firstspringboot.repository;

import com.example.firstspringboot.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Integer>{

   public List<Film> findAllByAnneeparutionOrderByAnneeparution(int annee);

}
