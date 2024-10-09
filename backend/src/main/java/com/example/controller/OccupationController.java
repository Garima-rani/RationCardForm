package com.example.controller;

import com.example.model.Occupation;
import com.example.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/occupations")
public class OccupationController {

    @Autowired
    private OccupationService occupationService;

    // Create a new Occupation
    @PostMapping
    public Occupation createOccupation(@RequestBody Occupation occupation) {
        return occupationService.createOccupation(occupation);
    }

    // Get all Occupations
    @GetMapping
    public List<Occupation> getAllOccupations() {
        return occupationService.getAllOccupations();
    }

    // Get Occupation by id
    @GetMapping("/{id}")
    public ResponseEntity<Occupation> getOccupationById(@PathVariable Long id) {
        Optional<Occupation> occupation = occupationService.getOccupationById(id);
        return occupation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Occupation by id
    @PutMapping("/{id}")
    public ResponseEntity<Occupation> updateOccupation(@PathVariable Long id, @RequestBody Occupation occupationDetails) {
        Optional<Occupation> updatedOccupation = occupationService.updateOccupation(id, occupationDetails);
        return updatedOccupation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Occupation by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOccupation(@PathVariable Long id) {
        boolean isDeleted = occupationService.deleteOccupation(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
