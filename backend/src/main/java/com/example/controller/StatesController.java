package com.example.controller;

import com.example.model.StateFullDto;
import com.example.model.StateWithLanguagesDto;
import com.example.model.States;
import com.example.service.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StatesController {

    @Autowired
    private StatesService statesService;

    // Fetch all states
//    @GetMapping
//    public List<States> getAllStates() {
//        return statesService.getAllStates();
//    }

    // Fetch languages mapped to a state by state id
    @GetMapping("/{id}/languages")
    public List<String> getLanguagesByStateId(@PathVariable Long id) {
        return statesService.getLanguagesByStateId(id);
    }

    // Create a new state
    @PostMapping
    public States createState(@RequestBody States state) {
        return statesService.createState(state);
    }

    // Update an existing state
    @PutMapping("/{id}")
    public States updateState(@PathVariable Long id, @RequestPart States state, @RequestPart(required = false) MultipartFile file) {
        return statesService.updateState(id, state, file);
    }

    // Delete a state
    @DeleteMapping("/{id}")
    public void deleteState(@PathVariable Long id) {
        statesService.deleteState(id);
    }
    
    // Endpoint to upload a document
    @PostMapping("/{id}/upload-document")
    public ResponseEntity<States> uploadDocument(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            byte[] document = file.getBytes();
            States updatedState = statesService.uploadDocument(id, document);
            return ResponseEntity.ok(updatedState);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // Endpoint to retrieve a document
    @GetMapping("/{id}/document")
    public ResponseEntity<byte[]> getDocument(@PathVariable Long id) {
        byte[] document = statesService.getDocument(id);
        return ResponseEntity.ok(document);
    }
    
    
    @GetMapping
    public ResponseEntity<List<StateFullDto>> getAllStatesOnly() {
        List<StateFullDto> states = statesService.getAllStatesOnly();
        return new ResponseEntity<>(states, HttpStatus.OK);
    }

    // Endpoint 2: Get states with mapped languages
    @GetMapping("/with-languages")
    public ResponseEntity<List<StateWithLanguagesDto>> getStatesWithLanguages() {
        List<StateWithLanguagesDto> statesWithLanguages = statesService.getStatesWithLanguages();
        return new ResponseEntity<>(statesWithLanguages, HttpStatus.OK);
    }
}