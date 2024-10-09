package com.example.controller;



import com.example.model.ProcurementType;
import com.example.service.ProcurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procurement-types")
public class ProcurementTypeController {

    @Autowired
    private ProcurementTypeService procurementTypeService;

    // Get all procurement types
    @GetMapping
    public ResponseEntity<List<ProcurementType>> getAllProcurementTypes() {
        List<ProcurementType> procurementTypes = procurementTypeService.getAllProcurementTypes();
        return ResponseEntity.ok(procurementTypes);
    }

    // Create a new procurement type
    @PostMapping
    public ResponseEntity<ProcurementType> createProcurementType(@RequestBody ProcurementType procurementType) {
        ProcurementType newProcurementType = procurementTypeService.createProcurementType(procurementType);
        return ResponseEntity.ok(newProcurementType);
    }

    // Update an existing procurement type
    @PutMapping("/{id}")
    public ResponseEntity<ProcurementType> updateProcurementType(
            @PathVariable Long id,
            @RequestBody ProcurementType procurementType
    ) {
        ProcurementType updatedProcurementType = procurementTypeService.updateProcurementType(id, procurementType);
        return ResponseEntity.ok(updatedProcurementType);
    }

    // Delete a procurement type by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcurementType(@PathVariable Long id) {
        procurementTypeService.deleteProcurementType(id);
        return ResponseEntity.noContent().build();
    }
}
