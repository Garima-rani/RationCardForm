package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.ModuleMaster;
import com.example.model.ModuleMasterDTO;
import com.example.service.ModuleMasterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modules")
public class ModuleMasterController {

    @Autowired
    private ModuleMasterService moduleMasterService;

    // Create a new module
    @PostMapping
    public ModuleMaster createModule(@RequestBody ModuleMaster moduleMaster) {
        return moduleMasterService.saveModule(moduleMaster);
    }

    // Get all modules
    @GetMapping
    public List<ModuleMaster> getAllModules() {
        return moduleMasterService.getAllModules();
    }

    // Get a module by ID
    @GetMapping("/{id}")
    public ResponseEntity<ModuleMaster> getModuleById(@PathVariable Long id) {
        Optional<ModuleMaster> module = moduleMasterService.getModuleById(id);
        return module.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a module
    @PutMapping("/id")
    public ResponseEntity<ModuleMaster> updateModule(@PathVariable Long id, @RequestBody ModuleMaster updatedModule) {
        Optional<ModuleMaster> module = moduleMasterService.getModuleById(id);
        if (module.isPresent()) {
            ModuleMaster existingModule = module.get();
            existingModule.setModuleName(updatedModule.getModuleName());
            existingModule.setFeedBy(updatedModule.getFeedBy());
            existingModule.setStatus(updatedModule.getStatus());
            existingModule.setRemarks(updatedModule.getRemarks());
            moduleMasterService.saveModule(existingModule);
            return ResponseEntity.ok(existingModule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a module
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        Optional<ModuleMaster> module = moduleMasterService.getModuleById(id);
        if (module.isPresent()) {
            moduleMasterService.deleteModuleById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/names")
    public List<ModuleMasterDTO> getAllModuleNames() {
        return moduleMasterService.getAllModuleNames();
    }
}
