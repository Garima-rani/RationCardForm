package com.example.service;

import com.example.model.NewMotherName;
import com.example.repository.NewMotherNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewMotherNameService {

    @Autowired
    private NewMotherNameRepository newMotherNameRepository;

    // Save a new mother name record
    public NewMotherName saveNewMotherName(NewMotherName newMotherName) {
        return newMotherNameRepository.save(newMotherName);
    }

    // Get all mother name records
    public List<NewMotherName> getAllMotherNames() {
        return newMotherNameRepository.findAll();
    }

    // Find a mother name record by ID
    public Optional<NewMotherName> getMotherNameById(Long id) {
        return newMotherNameRepository.findById(id);
    }

    // Delete a mother name record by ID
    public void deleteMotherNameById(Long id) {
        newMotherNameRepository.deleteById(id);
    }
}
