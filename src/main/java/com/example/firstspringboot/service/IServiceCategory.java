package com.example.firstspringboot.service;

import com.example.firstspringboot.entities.Category;

import java.util.List;


public interface IServiceCategory {

    public Category createCategory(Category c);
    public Category findCategoryById(int id);
    public Category updateCategory(Category c);
    public List<Category> findAllCategories();
    public void deleteCategory(Category c);
}
