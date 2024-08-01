package com.Church.ChurchMgtSystem.controller;

import com.Church.ChurchMgtSystem.model.Believer;
import com.Church.ChurchMgtSystem.repository.BelieverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
public class BelieverController {
    @Autowired
    private BelieverRepo believerRepo;

    @PostMapping("/believer")
    Believer newBeliever(@RequestBody Believer newBeliever) {
        return believerRepo.save(newBeliever);
    }

    @GetMapping("/believers")
    List<Believer> getAllBelievers() {
        return believerRepo.findAll();
    }

    @GetMapping("/believer/{id}")
    public Believer getBelieverById(@PathVariable int id) {
        Optional<Believer> optionalBeliever = believerRepo.findById(id);
        if (optionalBeliever.isPresent()) {
            return optionalBeliever.get();
        } else {
            throw new RuntimeException("Believer not found with id: " + id);
        }
    }

    @PutMapping("/believer/{id}")
    public Believer updateBeliever(@PathVariable int id, @RequestBody Believer updatedBeliever) {
        Optional<Believer> optionalBeliever = believerRepo.findById(id);
        if (optionalBeliever.isPresent()) {
            Believer believer = optionalBeliever.get();
            believer.setFirstName(updatedBeliever.getFirstName());
            believer.setLastName(updatedBeliever.getLastName());
            believer.setDOB(updatedBeliever.getDOB());
            believer.setGender(updatedBeliever.getGender());
            return believerRepo.save(believer);
        } else {
            throw new RuntimeException("Believer not found with id: " + id);
        }
    }

    @DeleteMapping("/believer/{id}")
    public void deleteBeliever(@PathVariable int id) {
        Optional<Believer> optionalBeliever = believerRepo.findById(id);
        if (optionalBeliever.isPresent()) {
            believerRepo.deleteById(id);
        } else {
            throw new RuntimeException("Believer not found with id: " + id);
        }
    }
}