package com.example.controller;

import com.example.model.BeneficiaryType;
import com.example.service.BeneficiaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiary-types")
public class BeneficiaryTypeController {

    @Autowired
    private BeneficiaryTypeService beneficiaryTypeService;

    @GetMapping
    public ResponseEntity<List<BeneficiaryType>> getAllBeneficiaryTypes() {
        List<BeneficiaryType> beneficiaryTypes = beneficiaryTypeService.getAllBeneficiaryTypes();
        return ResponseEntity.ok(beneficiaryTypes);
    }

    @PostMapping
    public ResponseEntity<BeneficiaryType> createBeneficiaryType(@RequestBody BeneficiaryType beneficiaryType) {
        BeneficiaryType createdBeneficiaryType = beneficiaryTypeService.createBeneficiaryType(beneficiaryType);
        return ResponseEntity.ok(createdBeneficiaryType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiaryType> updateBeneficiaryType(@PathVariable Long id, @RequestBody BeneficiaryType beneficiaryType) {
        BeneficiaryType updatedBeneficiaryType = beneficiaryTypeService.updateBeneficiaryType(id, beneficiaryType);
        return ResponseEntity.ok(updatedBeneficiaryType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeneficiaryType(@PathVariable Long id) {
        beneficiaryTypeService.deleteBeneficiaryType(id);
        return ResponseEntity.noContent().build();
    }
}
