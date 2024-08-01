package com.Church.ChurchMgtSystem.controller;

import com.Church.ChurchMgtSystem.model.Choir;
import com.Church.ChurchMgtSystem.repository.ChoirRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChoirController {
    @Autowired
    private ChoirRepo choirRepo;

    @PostMapping("/choir")
     Choir newChoir(@RequestBody Choir newChoir){
        return choirRepo.save(newChoir);
    }

    @GetMapping("/choirs")
    List<Choir> getAllChoirs(){
        return choirRepo.findAll();
    }
}
