package com.example.controller;

import com.example.model.NewGender;
import com.example.service.NewGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gender")
public class NewGenderController {

    @Autowired
    private NewGenderService newGenderService;

    // Create a new gender record
    @PostMapping
    public ResponseEntity<NewGender> createNewGender(@RequestBody NewGender newGender) {
        NewGender savedGender = newGenderService.saveNewGender(newGender);
        return ResponseEntity.ok(savedGender);
    }

    // Get all gender records
    @GetMapping
    public ResponseEntity<List<NewGender>> getAllGenders() {
        List<NewGender> genderList = newGenderService.getAllGenders();
        return ResponseEntity.ok(genderList);
    }

    // Get a gender record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewGender> getGenderById(@PathVariable Long id) {
        Optional<NewGender> gender = newGenderService.getGenderById(id);
        return gender.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // Delete a gender record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenderById(@PathVariable Long id) {
        newGenderService.deleteGenderById(id);
        return ResponseEntity.noContent().build();
    }
}
