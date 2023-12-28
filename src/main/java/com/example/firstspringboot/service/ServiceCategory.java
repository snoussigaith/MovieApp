package com.example.firstspringboot.service;

import com.example.firstspringboot.entities.Category;
import com.example.firstspringboot.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCategory implements IServiceCategory{
    @Autowired
    CategorieRepository categorieRepository;
    @Override
    public Category createCategory(Category c) {
        return categorieRepository.save(c);
    }

    @Override
    public Category findCategoryById(int id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public Category updateCategory(Category c) {
        return categorieRepository.save(c);
    }

    @Override
    public List<Category> findAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public void deleteCategory(Category c) {
        categorieRepository.delete(c);
    }
}
