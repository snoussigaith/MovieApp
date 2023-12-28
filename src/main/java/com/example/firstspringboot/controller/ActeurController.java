package com.example.firstspringboot.controller;

import com.example.firstspringboot.entities.Acteur;
import com.example.firstspringboot.service.IServiceActeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acteur")
public class ActeurController {
    @Autowired
    IServiceActeur iServiceActeur;

    @GetMapping("all")
    public String all(Model model){
        model.addAttribute("acteur",iServiceActeur.findAllActeur());
        return "afficheActeur";
    }

    @GetMapping("new")
    public String afficeNewActeurForm(){
        return "ajouteActeur";
    }

    @PostMapping("add")
    public String add(Acteur act){
        iServiceActeur.createActeur(act);
        return "redirect:/acteur/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id){
        iServiceActeur.deleteActeur(id);
        return "redirect:/acteur/all";
    }

    @GetMapping("edit/{id}")
    public String update(@PathVariable int id,Model model){
        model.addAttribute("acteur",iServiceActeur.findActeurById(id));
        return "editActeur";
    }

    @PostMapping("update")
    public String updateActeur(Acteur act){
        iServiceActeur.updateActeur(act);
        return "redirect:/acteur/all";
    }



}
