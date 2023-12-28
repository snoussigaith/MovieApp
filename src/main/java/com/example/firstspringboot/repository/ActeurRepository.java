package com.example.firstspringboot.repository;

import com.example.firstspringboot.entities.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeurRepository extends JpaRepository<Acteur,Integer> {
}
