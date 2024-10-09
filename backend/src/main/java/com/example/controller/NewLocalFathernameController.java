package com.example.controller;

import com.example.model.NewLocalFathername;
import com.example.service.NewLocalFathernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/localfathername")
public class NewLocalFathernameController {

    @Autowired
    private NewLocalFathernameService newLocalFathernameService;

    // Create a new local father name record
    @PostMapping
    public ResponseEntity<NewLocalFathername> createNewLocalFathername(@RequestBody NewLocalFathername newLocalFathername) {
        NewLocalFathername savedLocalFathername = newLocalFathernameService.saveNewLocalFathername(newLocalFathername);
        return ResponseEntity.ok(savedLocalFathername);
    }

    // Get all local father name records
    @GetMapping
    public ResponseEntity<List<NewLocalFathername>> getAllLocalFathernames() {
        List<NewLocalFathername> localFathernameList = newLocalFathernameService.getAllLocalFathernames();
        return ResponseEntity.ok(localFathernameList);
    }

    // Get a local father name record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewLocalFathername> getLocalFathernameById(@PathVariable Long id) {
        Optional<NewLocalFathername> localFathername = newLocalFathernameService.getLocalFathernameById(id);
        return localFathername.map(ResponseEntity::ok)
                              .orElse(ResponseEntity.notFound().build());
    }

    // Delete a local father name record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalFathernameById(@PathVariable Long id) {
        newLocalFathernameService.deleteLocalFathernameById(id);
        return ResponseEntity.noContent().build();
    }
}
