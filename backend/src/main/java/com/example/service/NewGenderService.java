package com.example.service;

import com.example.model.NewGender;
import com.example.repository.NewGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewGenderService {

    @Autowired
    private NewGenderRepository newGenderRepository;

    // Save a new gender record
    public NewGender saveNewGender(NewGender newGender) {
        return newGenderRepository.save(newGender);
    }

    // Get all gender records
    public List<NewGender> getAllGenders() {
        return newGenderRepository.findAll();
    }

    // Find a gender record by ID
    public Optional<NewGender> getGenderById(Long id) {
        return newGenderRepository.findById(id);
    }

    // Delete a gender record by ID
    public void deleteGenderById(Long id) {
        newGenderRepository.deleteById(id);
    }
}
