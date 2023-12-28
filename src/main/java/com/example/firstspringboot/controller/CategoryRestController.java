package com.example.firstspringboot.controller;

import com.example.firstspringboot.entities.Category;
import com.example.firstspringboot.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorie")
public class CategoryRestController {

    @Autowired
    IServiceCategory iServiceCategory;

    @GetMapping("")
    public List<Category> getAll(){
        return iServiceCategory.findAllCategories();
    }

    @GetMapping("{id}")
    public Category getCategorie(@PathVariable("id") int id){
        return iServiceCategory.findCategoryById(id);
    }

    @PostMapping("add")
    public Category addCategorie(@RequestBody Category category){
        return iServiceCategory.createCategory(category);
    }

    @DeleteMapping("{id}")
    public String deleteCategorie (@PathVariable("id") int id){
        Category category=iServiceCategory.findCategoryById(id);
         iServiceCategory.deleteCategory(category);
         return "la categorie est supprimer";
    }

    @PutMapping("update")
    public Category updateCategory(@RequestBody Category category){
        Category updateCategory=iServiceCategory.findCategoryById(category.getId());
        updateCategory.setNom(category.getNom());
        return iServiceCategory.updateCategory(updateCategory);
    }
}
