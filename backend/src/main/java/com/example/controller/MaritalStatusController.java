package com.example.controller;

import com.example.model.MaritalStatus;
import com.example.service.MaritalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marital-statuses")
public class MaritalStatusController {

    @Autowired
    private MaritalStatusService maritalStatusService;

    @GetMapping
    public ResponseEntity<List<MaritalStatus>> getAllMaritalStatuses() {
        List<MaritalStatus> maritalStatuses = maritalStatusService.getAllMaritalStatuses();
        return ResponseEntity.ok(maritalStatuses);
    }

    @PostMapping
    public ResponseEntity<MaritalStatus> createMaritalStatus(@RequestBody MaritalStatus maritalStatus) {
        MaritalStatus createdMaritalStatus = maritalStatusService.createMaritalStatus(maritalStatus);
        return ResponseEntity.ok(createdMaritalStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaritalStatus> updateMaritalStatus(@PathVariable Long id, @RequestBody MaritalStatus maritalStatus) {
        MaritalStatus updatedMaritalStatus = maritalStatusService.updateMaritalStatus(id, maritalStatus);
        return ResponseEntity.ok(updatedMaritalStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaritalStatus(@PathVariable Long id) {
        maritalStatusService.deleteMaritalStatus(id);
        return ResponseEntity.noContent().build();
    }
}
