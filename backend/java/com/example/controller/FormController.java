package com.example.controller;

import com.example.model.Form;
import com.example.service.FormService;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/forms")
public class FormController {

    @Autowired
    private FormService formService;
    
    @GetMapping
    public ResponseEntity<?> test() {
    	return ResponseEntity.ok("Form submitted successfully");
              
    }
    @PostMapping
    public ResponseEntity<?> submitForm(@RequestBody Form form) {
        // Handle the form data
    	System.out.print(form);
    	formService.saveFormWithMembers(form);
        return ResponseEntity.ok("Form submit ho chuka hai");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Form> getFormById(@PathVariable("id") Long id) {
        return formService.getFormById(id)
                .map(form -> new ResponseEntity<>(form, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
