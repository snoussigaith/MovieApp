package com.example.firstspringboot.service;

import com.example.firstspringboot.entities.Acteur;
import com.example.firstspringboot.repository.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceActeur implements IServiceActeur{

    @Autowired
    ActeurRepository acteurRepository;
    @Override
    public Acteur createActeur(Acteur act) {

        return acteurRepository.save(act);
    }

    @Override
    public Acteur findActeurById(int id) {
        return acteurRepository.findById(id).get();
    }

    @Override
    public Acteur updateActeur(Acteur act) {

        return acteurRepository.save(act);
    }

    @Override
    public List<Acteur> findAllActeur() {
        return acteurRepository.findAll();
    }

    @Override
    public void deleteActeur(int id) {
        acteurRepository.deleteById(id);
    }

    @Override
    public Boolean acteurExist(int id){
        return  acteurRepository.existsById(id);

    }
}
