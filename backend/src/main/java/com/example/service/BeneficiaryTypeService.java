package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.BeneficiaryType;
import com.example.repository.BeneficiaryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryTypeService {

    @Autowired
    private BeneficiaryTypeRepository beneficiaryTypeRepository;

    // Fetch all beneficiary types
    public List<BeneficiaryType> getAllBeneficiaryTypes() {
        return beneficiaryTypeRepository.findAll();
    }

    // Create a new beneficiary type
    public BeneficiaryType createBeneficiaryType(BeneficiaryType beneficiaryType) {
        return beneficiaryTypeRepository.save(beneficiaryType);
    }

    // Update an existing beneficiary type by ID
    public BeneficiaryType updateBeneficiaryType(Long id, BeneficiaryType beneficiaryType) {
        BeneficiaryType existingBeneficiaryType = beneficiaryTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Beneficiary Type not found with id: " + id));
        existingBeneficiaryType.setName(beneficiaryType.getName());
        return beneficiaryTypeRepository.save(existingBeneficiaryType);
    }

    // Delete a beneficiary type by ID
    public void deleteBeneficiaryType(Long id) {
        if (!beneficiaryTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Beneficiary Type not found with id: " + id);
        }
        beneficiaryTypeRepository.deleteById(id);
    }
}
