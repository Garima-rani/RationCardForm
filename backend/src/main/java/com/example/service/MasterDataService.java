package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.model.OwnershipType;
import com.example.model.ProcurementType;
import com.example.repository.CategoryRepository;
import com.example.repository.OwnershipTypeRepository;
import com.example.repository.ProcurementTypeRepository;

import java.util.List;

@Service
public class MasterDataService {

    @Autowired
    private ProcurementTypeRepository procurementTypeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OwnershipTypeRepository ownershipTypeRepository;

    // Procurement Type Master Data Operations
    public List<ProcurementType> getAllProcurementTypes() {
        return procurementTypeRepository.findAll();
    }

    public ProcurementType createProcurementType(ProcurementType procurementType) {
        return procurementTypeRepository.save(procurementType);
    }

    public ProcurementType updateProcurementType(Long id, ProcurementType procurementType) {
        if (!procurementTypeRepository.existsById(id)) {
            return null; // or throw an exception
        }
        procurementType.setId(id); // assuming ProcurementType has a setId method
        return procurementTypeRepository.save(procurementType);
    }

    public void deleteProcurementType(Long id) {
        procurementTypeRepository.deleteById(id);
    }

    // Category Master Data Operations
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        if (!categoryRepository.existsById(id)) {
            return null; // or throw an exception
        }
        category.setId(id); // assuming Category has a setId method
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    // Ownership Type Master Data Operations
    public List<OwnershipType> getAllOwnershipTypes() {
        return ownershipTypeRepository.findAll();
    }

    public OwnershipType createOwnershipType(OwnershipType ownershipType) {
        return ownershipTypeRepository.save(ownershipType);
    }

    public OwnershipType updateOwnershipType(Long id, OwnershipType ownershipType) {
        if (!ownershipTypeRepository.existsById(id)) {
            return null; // or throw an exception
        }
        ownershipType.setId(id); // assuming OwnershipType has a setId method
        return ownershipTypeRepository.save(ownershipType);
    }

    public void deleteOwnershipType(Long id) {
        ownershipTypeRepository.deleteById(id);
    }
}
