package com.example.controller;



import com.example.model.OwnershipType;
import com.example.service.OwnershipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ownership-types")
public class OwnershipTypeController {

    @Autowired
    private OwnershipTypeService ownershipTypeService;

    // Get all ownership types
    @GetMapping
    public ResponseEntity<List<OwnershipType>> getAllOwnershipTypes() {
        List<OwnershipType> ownershipTypes = ownershipTypeService.getAllOwnershipTypes();
        return ResponseEntity.ok(ownershipTypes);
    }

    // Create a new ownership type
    @PostMapping
    public ResponseEntity<OwnershipType> createOwnershipType(@RequestBody OwnershipType ownershipType) {
        OwnershipType newOwnershipType = ownershipTypeService.createOwnershipType(ownershipType);
        return ResponseEntity.ok(newOwnershipType);
    }

    // Update an existing ownership type
    @PutMapping("/{id}")
    public ResponseEntity<OwnershipType> updateOwnershipType(
            @PathVariable Long id,
            @RequestBody OwnershipType ownershipType
    ) {
        OwnershipType updatedOwnershipType = ownershipTypeService.updateOwnershipType(id, ownershipType);
        return ResponseEntity.ok(updatedOwnershipType);
    }

    // Delete an ownership type by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwnershipType(@PathVariable Long id) {
        ownershipTypeService.deleteOwnershipType(id);
        return ResponseEntity.noContent().build();
    }
}
