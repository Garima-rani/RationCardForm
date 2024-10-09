package com.example.controller;

import com.example.model.NewLocalMothername;
import com.example.service.NewLocalMothernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/localmothername")
public class NewLocalMothernameController {

    @Autowired
    private NewLocalMothernameService newLocalMothernameService;

    // Create a new local mother name record
    @PostMapping
    public ResponseEntity<NewLocalMothername> createNewLocalMothername(@RequestBody NewLocalMothername newLocalMothername) {
        NewLocalMothername savedLocalMothername = newLocalMothernameService.saveNewLocalMothername(newLocalMothername);
        return ResponseEntity.ok(savedLocalMothername);
    }

    // Get all local mother name records
    @GetMapping
    public ResponseEntity<List<NewLocalMothername>> getAllLocalMothernames() {
        List<NewLocalMothername> localMothernameList = newLocalMothernameService.getAllLocalMothernames();
        return ResponseEntity.ok(localMothernameList);
    }

    // Get a local mother name record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewLocalMothername> getLocalMothernameById(@PathVariable Long id) {
        Optional<NewLocalMothername> localMothername = newLocalMothernameService.getLocalMothernameById(id);
        return localMothername.map(ResponseEntity::ok)
                              .orElse(ResponseEntity.notFound().build());
    }

    // Delete a local mother name record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalMothernameById(@PathVariable Long id) {
        newLocalMothernameService.deleteLocalMothernameById(id);
        return ResponseEntity.noContent().build();
    }
}
