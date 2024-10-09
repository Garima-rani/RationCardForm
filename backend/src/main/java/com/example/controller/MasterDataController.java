package com.example.controller;

import com.example.model.Category;
import com.example.model.MasterDataDTO;
import com.example.model.OwnershipType;
import com.example.model.ProcurementType;
import com.example.model.States;
import com.example.service.CategoryService;
import com.example.service.OwnershipTypeService;
import com.example.service.ProcurementTypeService;
import com.example.service.StatesService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/masters")
public class MasterDataController {

    @Autowired
    private ProcurementTypeService procurementTypeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OwnershipTypeService ownershipTypeService;

    @Autowired
    private StatesService statesService;

    // Combined endpoint to get all master data
    @GetMapping("/master-data")
    public MasterDataDTO getAllMasterData() {
        List<ProcurementType> procurementTypes = procurementTypeService.getAllProcurementTypes();
        List<Category> categories = categoryService.getAllCategories();
        List<OwnershipType> ownershipTypes = ownershipTypeService.getAllOwnershipTypes();
        return new MasterDataDTO(procurementTypes, categories, ownershipTypes);
    }

    // CRUD operations for Procurement Types
    @GetMapping("/procurement-types")
    public ResponseEntity<List<ProcurementType>> getProcurementTypes() {
        List<ProcurementType> procurementTypes = procurementTypeService.getAllProcurementTypes();
        return ResponseEntity.ok(procurementTypes);
    }

    @PostMapping("/procurement-types")
    public ResponseEntity<ProcurementType> createProcurementType(@RequestBody ProcurementType procurementType) {
        ProcurementType createdType = procurementTypeService.createProcurementType(procurementType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdType);
    }

    @PutMapping("/procurement-types/{id}")
    public ResponseEntity<ProcurementType> updateProcurementType(@PathVariable Long id, @RequestBody ProcurementType procurementType) {
        ProcurementType updatedType = procurementTypeService.updateProcurementType(id, procurementType);
        if (updatedType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedType);
    }

    @DeleteMapping("/procurement-types/{id}")
    public ResponseEntity<Void> deleteProcurementType(@PathVariable Long id) {
        procurementTypeService.deleteProcurementType(id);
        return ResponseEntity.ok().build();
    }

    // CRUD operations for Categories
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        if (updatedCategory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    // CRUD operations for Ownership Types
    @GetMapping("/ownership-types")
    public ResponseEntity<List<OwnershipType>> getOwnershipTypes() {
        List<OwnershipType> ownershipTypes = ownershipTypeService.getAllOwnershipTypes();
        return ResponseEntity.ok(ownershipTypes);
    }

    @PostMapping("/ownership-types")
    public ResponseEntity<OwnershipType> createOwnershipType(@RequestBody OwnershipType ownershipType) {
        OwnershipType createdOwnershipType = ownershipTypeService.createOwnershipType(ownershipType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOwnershipType);
    }

    @PutMapping("/ownership-types/{id}")
    public ResponseEntity<OwnershipType> updateOwnershipType(@PathVariable Long id, @RequestBody OwnershipType ownershipType) {
        OwnershipType updatedOwnershipType = ownershipTypeService.updateOwnershipType(id, ownershipType);
        if (updatedOwnershipType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedOwnershipType);
    }

    @DeleteMapping("/ownership-types/{id}")
    public ResponseEntity<Void> deleteOwnershipType(@PathVariable Long id) {
        ownershipTypeService.deleteOwnershipType(id);
        return ResponseEntity.ok().build();
    }

    // CRUD operations for States
    @GetMapping("/states")
    public ResponseEntity<List<States>> getStates() {
        List<States> statesList = statesService.getAllStates();
        return ResponseEntity.ok(statesList);
    }

    @PostMapping
    public ResponseEntity<?> createState(@Validated @RequestBody States state) {
        try {
            States createdState = statesService.createState(state);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdState);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid state name: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating state: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public States updateState(@PathVariable Long id, @RequestPart States state, @RequestPart(required = false) MultipartFile file) {
        return statesService.updateState(id, state, file);
    }

    @DeleteMapping("/states/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
        statesService.deleteState(id);
        return ResponseEntity.ok().build();
    }
}
