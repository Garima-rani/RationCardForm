package com.example.controller;

import com.example.model.Gender;
import com.example.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping
    public ResponseEntity<List<Gender>> getAllGenders() {
        List<Gender> genders = genderService.getAllGenders();
        return ResponseEntity.ok(genders);
    }

    @PostMapping
    public ResponseEntity<Gender> createGender(@RequestBody Gender gender) {
        Gender createdGender = genderService.createGender(gender);
        return ResponseEntity.ok(createdGender);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gender> updateGender(@PathVariable Long id, @RequestBody Gender gender) {
        Gender updatedGender = genderService.updateGender(id, gender);
        return ResponseEntity.ok(updatedGender);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGender(@PathVariable Long id) {
        genderService.deleteGender(id);
        return ResponseEntity.noContent().build();
    }
}
