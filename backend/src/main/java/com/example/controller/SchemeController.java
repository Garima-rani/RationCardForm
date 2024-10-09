package com.example.controller;

import com.example.model.Scheme;
import com.example.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schemes")
public class SchemeController {

    @Autowired
    private SchemeService schemeService;

    @GetMapping
    public ResponseEntity<List<Scheme>> getAllSchemes() {
        List<Scheme> schemes = schemeService.getAllSchemes();
        return ResponseEntity.ok(schemes);
    }

    @PostMapping
    public ResponseEntity<Scheme> createScheme(@RequestBody Scheme scheme) {
        Scheme createdScheme = schemeService.createScheme(scheme);
        return ResponseEntity.ok(createdScheme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scheme> updateScheme(@PathVariable Long id, @RequestBody Scheme scheme) {
        Scheme updatedScheme = schemeService.updateScheme(id, scheme);
        return ResponseEntity.ok(updatedScheme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheme(@PathVariable Long id) {
        schemeService.deleteScheme(id);
        return ResponseEntity.noContent().build();
    }
}
