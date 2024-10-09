package com.example.controller;

import com.example.model.NewNationality;
import com.example.service.NewNationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/new-nationalities")   
public class NewNationalityController {
    @Autowired
    private NewNationalityService newNationalityService;

    // Create a new nationality record
    @PostMapping
    public ResponseEntity<NewNationality> createNewNationality(@RequestBody NewNationality newNationality) {
        NewNationality savedNewNationality = newNationalityService.saveNewNationality(newNationality);
        return ResponseEntity.ok(savedNewNationality);
    }

    // Get all nationality records
    @GetMapping
    public ResponseEntity<List<NewNationality>> getAllNewNationalities() {
        List<NewNationality> newNationalityList = newNationalityService.getAllNewNationalities();
        return ResponseEntity.ok(newNationalityList);
    }

    // Get a nationality record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewNationality> getNewNationalityById(@PathVariable Long id) {
        Optional<NewNationality> newNationality = newNationalityService.getNewNationalityById(id);
        return newNationality.map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }

    // Delete a nationality record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNewNationalityById(@PathVariable Long id) {
        newNationalityService.deleteNewNationalityById(id);
        return ResponseEntity.noContent().build();
    }
}
