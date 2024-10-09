package com.example.controller;

import com.example.model.Nationality;
import com.example.service.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nationalities")
public class NationalityController {

    @Autowired
    private NationalityService nationalityService;

    @GetMapping
    public ResponseEntity<List<Nationality>> getAllNationalities() {
        List<Nationality> nationalities = nationalityService.getAllNationalities();
        return ResponseEntity.ok(nationalities);
    }

    @PostMapping
    public ResponseEntity<Nationality> createNationality(@RequestBody Nationality nationality) {
        Nationality createdNationality = nationalityService.createNationality(nationality);
        return ResponseEntity.ok(createdNationality);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nationality> updateNationality(@PathVariable Long id, @RequestBody Nationality nationality) {
        Nationality updatedNationality = nationalityService.updateNationality(id, nationality);
        return ResponseEntity.ok(updatedNationality);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNationality(@PathVariable Long id) {
        nationalityService.deleteNationality(id);
        return ResponseEntity.noContent().build();
    }
}
