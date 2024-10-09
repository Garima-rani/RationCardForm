package com.example.controller;

import com.example.model.NewFatherName;
import com.example.service.NewFatherNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/father-name")
public class NewFatherNameController {

    @Autowired
    private NewFatherNameService newFatherNameService;

    // Create a new father name record
    @PostMapping
    public ResponseEntity<NewFatherName> createNewFatherName(@RequestBody NewFatherName newFatherName) {
        NewFatherName savedFatherName = newFatherNameService.saveNewFatherName(newFatherName);
        return ResponseEntity.ok(savedFatherName);
    }

    // Get all father name records
    @GetMapping
    public ResponseEntity<List<NewFatherName>> getAllFatherNames() {
        List<NewFatherName> fatherNameList = newFatherNameService.getAllFatherNames();
        return ResponseEntity.ok(fatherNameList);
    }

    // Get a father name record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewFatherName> getFatherNameById(@PathVariable Long id) {
        Optional<NewFatherName> fatherName = newFatherNameService.getFatherNameById(id);
        return fatherName.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    // Delete a father name record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFatherNameById(@PathVariable Long id) {
        newFatherNameService.deleteFatherNameById(id);
        return ResponseEntity.noContent().build();
    }
}
