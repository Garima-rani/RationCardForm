package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.NewUserName;
import com.example.service.NewUserNameService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usernames")
public class NewUserNameController {

    @Autowired
    private NewUserNameService service;

    @GetMapping
    public List<NewUserName> getAllUserNames() {
        return service.getAllUserNames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewUserName> getUserNameById(@PathVariable("id") Long id) {
        Optional<NewUserName> userName = service.getUserNameById(id);
        return userName.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NewUserName> createUserName(@RequestBody NewUserName userName) {
        NewUserName savedUserName = service.saveUserName(userName);
        return ResponseEntity.ok(savedUserName);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewUserName> updateUserName(@PathVariable("id") Long id, @RequestBody NewUserName userName) {
        if (!service.getUserNameById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userName.setId(id);
        NewUserName updatedUserName = service.saveUserName(userName);
        return ResponseEntity.ok(updatedUserName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserName(@PathVariable("id") Long id) {
        if (!service.getUserNameById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteUserName(id);
        return ResponseEntity.noContent().build();
    }
}
