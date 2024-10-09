package com.example.controller;

import com.example.model.NewMobileNo;
import com.example.service.NewMobileNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/new-mobile-nos")
public class NewMobileNoController {

    @Autowired
    private NewMobileNoService newMobileNoService;

    // Create a new mobile number record
    @PostMapping
    public ResponseEntity<NewMobileNo> createNewMobileNo(@RequestBody NewMobileNo newMobileNo) {
        NewMobileNo savedNewMobileNo = newMobileNoService.saveNewMobileNo(newMobileNo);
        return ResponseEntity.ok(savedNewMobileNo);
    }

    // Get all mobile number records
    @GetMapping
    public ResponseEntity<List<NewMobileNo>> getAllNewMobileNos() {
        List<NewMobileNo> newMobileNoList = newMobileNoService.getAllNewMobileNos();
        return ResponseEntity.ok(newMobileNoList);
    }

    // Get a mobile number record by ID
    @GetMapping("/{id}")
    public ResponseEntity<NewMobileNo> getNewMobileNoById(@PathVariable Long id) {
        Optional<NewMobileNo> newMobileNo = newMobileNoService.getNewMobileNoById(id);
        return newMobileNo.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // Delete a mobile number record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNewMobileNoById(@PathVariable Long id) {
        newMobileNoService.deleteNewMobileNoById(id);
        return ResponseEntity.noContent().build();
    }
}
