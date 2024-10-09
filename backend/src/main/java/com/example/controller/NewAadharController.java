package com.example.controller;

import com.example.model.New_Aadhar;
import com.example.service.NewAadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aadhar")
public class NewAadharController {

    @Autowired
    private NewAadharService newAadharService;

  
    @PostMapping
    public ResponseEntity<New_Aadhar> createNewAadhar(@RequestBody New_Aadhar newAadhar) {
        New_Aadhar savedAadhar = newAadharService.saveNewAadhar(newAadhar);
        return ResponseEntity.ok(savedAadhar);
    }

   
    @GetMapping
    public ResponseEntity<List<New_Aadhar>> getAllAadharRecords() {
        List<New_Aadhar> aadharList = newAadharService.getAllAadharRecords();
        return ResponseEntity.ok(aadharList);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<New_Aadhar> getAadharById(@PathVariable Long id) {
        Optional<New_Aadhar> aadhar = newAadharService.getAadharById(id);
        return aadhar.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAadharById(@PathVariable Long id) {
        newAadharService.deleteAadharById(id);
        return ResponseEntity.noContent().build();
    }
}
