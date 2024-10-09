package com.example.controller;

import com.example.model.NewLocalUsername;
import com.example.service.NewLocalUsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/localusername")
public class NewLocalUsernameController {

    @Autowired
    private NewLocalUsernameService newLocalUsernameService;

    // Create a new local username record
    @PostMapping
    public ResponseEntity<NewLocalUsername> createNewLocalUsername(@RequestBody NewLocalUsername newLocalUsername) {
        NewLocalUsername savedLocalUsername = newLocalUsernameService.saveNewLocalUsername(newLocalUsername);
        return ResponseEntity.ok(savedLocalUsername);
    }

    // Get all local username records
    @GetMapping
    public ResponseEntity<List<NewLocalUsername>> getAllLocalUsernames() {
        List<NewLocalUsername> localUsernameList = newLocalUsernameService.getAllLocalUsernames();
        return ResponseEntity.ok(localUsernameList);
    }

    // Get a local username record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewLocalUsername> getLocalUsernameById(@PathVariable Long id) {
        Optional<NewLocalUsername> localUsername = newLocalUsernameService.getLocalUsernameById(id);
        return localUsername.map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }

    // Delete a local username record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalUsernameById(@PathVariable Long id) {
        newLocalUsernameService.deleteLocalUsernameById(id);
        return ResponseEntity.noContent().build();
    }
}
