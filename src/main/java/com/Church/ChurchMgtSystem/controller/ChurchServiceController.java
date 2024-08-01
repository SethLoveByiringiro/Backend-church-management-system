package com.Church.ChurchMgtSystem.controller;

import com.Church.ChurchMgtSystem.model.ChurchService;
import com.Church.ChurchMgtSystem.repository.ChurchServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChurchServiceController {

    @Autowired
    private ChurchServiceRepo churchServiceRepo;

    @PostMapping("/service")
    public ResponseEntity<ChurchService> newService(@RequestBody ChurchService service) {
        try {
            ChurchService savedService = churchServiceRepo.save(service);
            return new ResponseEntity<>(savedService, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/services")
    public ResponseEntity<List<ChurchService>> getAllServices() {
        try {
            List<ChurchService> services = churchServiceRepo.findAll();
            if (services.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(services, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<ChurchService> getServiceById(@PathVariable int id) {
        Optional<ChurchService> optionalService = churchServiceRepo.findById(id);
        if (optionalService.isPresent()) {
            return new ResponseEntity<>(optionalService.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/service/{id}")
    public ResponseEntity<ChurchService> updateService(@PathVariable int id, @RequestBody ChurchService updatedService) {
        Optional<ChurchService> optionalService = churchServiceRepo.findById(id);
        if (optionalService.isPresent()) {
            ChurchService service = optionalService.get();
            service.setDay(updatedService.getDay());
            service.setStarting_hour(updatedService.getStarting_hour());
            service.setEnding_hour(updatedService.getEnding_hour());
            return new ResponseEntity<>(churchServiceRepo.save(service), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<HttpStatus> deleteService(@PathVariable int id) {
        try {
            churchServiceRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
