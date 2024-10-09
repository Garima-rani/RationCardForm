package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.OwnershipType;
import com.example.repository.OwnershipTypeRepository;

import java.util.List;

@Service
public class OwnershipTypeService {

    @Autowired
    private OwnershipTypeRepository ownershipTypeRepository;

    public List<OwnershipType> getAllOwnershipTypes() {
        return ownershipTypeRepository.findAll();
    }

    public OwnershipType createOwnershipType(OwnershipType ownershipType) {
        return ownershipTypeRepository.save(ownershipType);
    }

    public OwnershipType updateOwnershipType(Long id, OwnershipType ownershipType) {
        ownershipType.setId(id);
        return ownershipTypeRepository.save(ownershipType);
    }

    public void deleteOwnershipType(Long id) {
        ownershipTypeRepository.deleteById(id);
    }

    public OwnershipType getOwnershipTypeById(Long ownershipTypeId) {
        return ownershipTypeRepository.findById(ownershipTypeId)
            .orElseThrow(() -> new ResourceNotFoundException("Ownership Type not found with id: " + ownershipTypeId));
    }
}

