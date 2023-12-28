package com.example.firstspringboot.service;

import com.example.firstspringboot.entities.Acteur;

import java.util.List;

public interface IServiceActeur {
    Acteur createActeur(Acteur act);
    Acteur findActeurById(int id);
    Acteur updateActeur(Acteur act);
    List<Acteur> findAllActeur();
    void deleteActeur(int id);
    public Boolean acteurExist(int id);
}
