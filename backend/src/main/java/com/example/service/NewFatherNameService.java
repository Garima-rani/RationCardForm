package com.example.service;

import com.example.model.NewFatherName;
import com.example.repository.NewFatherNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewFatherNameService {

    @Autowired
    private NewFatherNameRepository newFatherNameRepository;

    // Save a new father name record
    public NewFatherName saveNewFatherName(NewFatherName newFatherName) {
        return newFatherNameRepository.save(newFatherName);
    }

    // Get all father name records
    public List<NewFatherName> getAllFatherNames() {
        return newFatherNameRepository.findAll();
    }

    // Find a father name record by ID
    public Optional<NewFatherName> getFatherNameById(Long id) {
        return newFatherNameRepository.findById(id);
    }

    // Delete a father name record by ID
    public void deleteFatherNameById(Long id) {
        newFatherNameRepository.deleteById(id);
    }
}
