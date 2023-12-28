package com.example.firstspringboot.controller;

import com.example.firstspringboot.entities.Film;
import com.example.firstspringboot.service.IServiceActeur;
import com.example.firstspringboot.service.IServiceFilm;
import com.example.firstspringboot.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/film")
public class FilmController {
    @Autowired
    IServiceFilm iServiceFilm;
    @Autowired
    IServiceCategory iServiceCategory;
    @Autowired
    IServiceActeur iServiceActeur;
@GetMapping("all")
    public String all(Model model) {
    model.addAttribute("films", iServiceFilm.findAllFilms());

    return "affiche";
}
@GetMapping("new")
public String afficheNewForm(Model model){
  model.addAttribute("categories",iServiceCategory.findAllCategories());
  model.addAttribute("acteurs",iServiceActeur.findAllActeur());
  return "ajoute";
}
@PostMapping("add")
    public String add(Film f){
    //System.out.println("-----------------"+f);
    iServiceFilm.createFilm(f);
    return "redirect:/film/all";
}
@GetMapping("delete/{id}")
    public String delete(@PathVariable int id){
    iServiceFilm.deleteFilm(id);
    return "redirect:/film/all";
}
@GetMapping("edit/{id}")
    public String update(@PathVariable int id,Model model){

    model.addAttribute("film",iServiceFilm.findFilmById(id));
    model.addAttribute("categories",iServiceCategory.findAllCategories());
    return "edit";
}
@PostMapping("update")
    public String updateFilm(Film f){
    iServiceFilm.updateFilm(f);
    return "redirect:/film/all";
}

}
