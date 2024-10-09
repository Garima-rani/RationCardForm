package com.example.controller;

import com.example.model.NewEmail;
import com.example.service.NewEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/email")
public class NewEmailController {

    @Autowired
    private NewEmailService newEmailService;

    // Create a new email record
    @PostMapping
    public ResponseEntity<NewEmail> createNewEmail(@RequestBody NewEmail newEmail) {
        NewEmail savedEmail = newEmailService.saveNewEmail(newEmail);
        return ResponseEntity.ok(savedEmail);
    }

    // Get all email records
    @GetMapping
    public ResponseEntity<List<NewEmail>> getAllEmails() {
        List<NewEmail> emailList = newEmailService.getAllEmails();
        return ResponseEntity.ok(emailList);
    }

    // Get an email record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewEmail> getEmailById(@PathVariable Long id) {
        Optional<NewEmail> email = newEmailService.getEmailById(id);
        return email.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // Delete an email record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmailById(@PathVariable Long id) {
        newEmailService.deleteEmailById(id);
        return ResponseEntity.noContent().build();
    }
}
