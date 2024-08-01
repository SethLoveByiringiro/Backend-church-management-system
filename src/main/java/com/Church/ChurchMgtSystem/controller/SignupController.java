package com.Church.ChurchMgtSystem.controller;

import com.Church.ChurchMgtSystem.model.Signup;
import com.Church.ChurchMgtSystem.repository.SignupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SignupController {
    @Autowired
    private SignupRepo signupRepo;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/user")
    public Signup createUser(@RequestBody Signup user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
        return signupRepo.save(user);
    }

    @GetMapping("/users")
    public List<Signup> getAllUsers() {
        return signupRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public Signup getUserById(@PathVariable int id) {
        Optional<Signup> optionalUser = signupRepo.findById(id);
        return optionalUser.orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PutMapping("/user/{id}")
    public Signup updateUser(@PathVariable int id, @RequestBody Signup updatedUser) {
        Optional<Signup> optionalUser = signupRepo.findById(id);
        if (optionalUser.isPresent()) {
            Signup user = optionalUser.get();
            user.setFirstname(updatedUser.getFirstname());
            user.setLastname(updatedUser.getLastname());
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            user.setConfirmPassword(passwordEncoder.encode(updatedUser.getConfirmPassword()));
            user.setRole(updatedUser.getRole());
            return signupRepo.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        signupRepo.deleteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Signup credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        Optional<Signup> optionalUser = signupRepo.findByUsername(username);

        if (optionalUser.isPresent()) {
            Signup user = optionalUser.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                String role = user.getRole();

                if (role.equalsIgnoreCase("believer")) {
                    return new ResponseEntity<>("Believer dashboard", HttpStatus.OK);
                } else if (role.equalsIgnoreCase("Admin")) {
                    return new ResponseEntity<>("Admin dashboard", HttpStatus.OK);
                } else if (role.equalsIgnoreCase("Church Leader")) {
                    return new ResponseEntity<>("Church leader dashboard", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Invalid role", HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
