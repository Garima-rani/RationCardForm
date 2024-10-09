package com.example.controller;

import com.example.model.NewMotherName;
import com.example.service.NewMotherNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mother-name")
public class NewMotherNameController {

    @Autowired
    private NewMotherNameService newMotherNameService;

    // Create a new mother name record
    @PostMapping
    public ResponseEntity<NewMotherName> createNewMotherName(@RequestBody NewMotherName newMotherName) {
        NewMotherName savedMotherName = newMotherNameService.saveNewMotherName(newMotherName);
        return ResponseEntity.ok(savedMotherName);
    }

    // Get all mother name records
    @GetMapping
    public ResponseEntity<List<NewMotherName>> getAllMotherNames() {
        List<NewMotherName> motherNameList = newMotherNameService.getAllMotherNames();
        return ResponseEntity.ok(motherNameList);
    }

    // Get a mother name record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewMotherName> getMotherNameById(@PathVariable Long id) {
        Optional<NewMotherName> motherName = newMotherNameService.getMotherNameById(id);
        return motherName.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    // Delete a mother name record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotherNameById(@PathVariable Long id) {
        newMotherNameService.deleteMotherNameById(id);
        return ResponseEntity.noContent().build();
    }
}
