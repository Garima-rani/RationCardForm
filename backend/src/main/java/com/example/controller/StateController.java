//package com.example.controller;
//
//import com.example.model.State;
//import com.example.service.StateService;
//import com.example.service.StatesService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/states")
//public class StateController {
//
//    @Autowired
//    private StatesService stateService;
//
//    // Get all states
//    @GetMapping
//    public ResponseEntity<List<State>> getAllStates() {
//        List<State> states = stateService.getAllStates();
//        return ResponseEntity.ok(states);
//    }
//
//    // Create a new state
//    @PostMapping
//    public ResponseEntity<State> createState(@RequestBody State state) {
//        State createdState = stateService.createState(state);
//        return ResponseEntity.ok(createdState);
//    }
//
//    // Update an existing state
//    @PutMapping("/{id}")
//    public ResponseEntity<State> updateState(@PathVariable Long id, @RequestBody State state) {
//        State updatedState = stateService.updateState(id, state);
//        return ResponseEntity.ok(updatedState);
//    }
//
//    // Delete a state
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
//        stateService.deleteState(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Partial update for a state
//    @PatchMapping("/{id}")
//    public ResponseEntity<State> partialUpdateState(@PathVariable Long id, @RequestBody State partialState) {
//        State updatedState = stateService.partialUpdateState(id, partialState);
//        return ResponseEntity.ok(updatedState);
//    }
//
//    // Get state by ID (if needed)
//    @GetMapping("/{id}")
//    public ResponseEntity<State> getStateById(@PathVariable Long id) {
//        State state = stateService.getStateById(id);
//        return ResponseEntity.ok(state);
//    }
//}
