package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.DropdownOptionService;

@RestController
@RequestMapping("/api/dropdown")
public class DropdownOptionController {

    @Autowired
    private DropdownOptionService dropdownOptionService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDropdownOption(@PathVariable Long id) {
        dropdownOptionService.deleteDropdownOption(id);
        return ResponseEntity.noContent().build();  // Returns 204 No Content
    }
}
