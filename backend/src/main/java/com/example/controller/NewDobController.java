package com.example.controller;

import com.example.model.NewDob;
import com.example.service.NewDobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dob")
public class NewDobController {

    @Autowired
    private NewDobService newDobService;

    // Create a new DOB record
    @PostMapping
    public ResponseEntity<NewDob> createNewDob(@RequestBody NewDob newDob) {
        NewDob savedDob = newDobService.saveNewDob(newDob);
        return ResponseEntity.ok(savedDob);
    }

    // Get all DOB records
    @GetMapping
    public ResponseEntity<List<NewDob>> getAllDobs() {
        List<NewDob> dobList = newDobService.getAllDobs();
        return ResponseEntity.ok(dobList);
    }

    // Get a DOB record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewDob> getDobById(@PathVariable Long id) {
        Optional<NewDob> dob = newDobService.getDobById(id);
        return dob.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    // Delete a DOB record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDobById(@PathVariable Long id) {
        newDobService.deleteDobById(id);
        return ResponseEntity.noContent().build();
    }
}
