package com.example.first_project.controller;

import java.util.List;

import com.example.first_project.dao.AlienRepo;
import com.example.first_project.model.Alien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aliens")
public class AlienController {

    @Autowired
    AlienRepo repo;

    @GetMapping("")
    public List<Alien> getAliens(){
        return repo.findAll();
    }

    @GetMapping(value = "/{aid}")
    public Alien getAlien(@PathVariable("aid") int aid){
        Alien alien=repo.findById(aid).orElse(null);
        return alien;
    }

    @PostMapping("/add")
    public Alien store(Alien alien){
        return repo.save(alien);
    }

    @DeleteMapping("/{aid}")
    public String delete(@PathVariable("aid") int aid){
        repo.deleteById(aid);
        return "Deleted";
    }

    @PutMapping("/update")
    public Alien update(Alien alien){
        return repo.save(alien);
    }
}