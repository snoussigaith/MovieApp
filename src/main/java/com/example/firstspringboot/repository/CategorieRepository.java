package com.example.firstspringboot.repository;

import com.example.firstspringboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Category,Integer> {
}
