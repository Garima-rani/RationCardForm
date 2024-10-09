package com.example.service;

import com.example.model.NewDob;
import com.example.repository.NewDobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewDobService {

    @Autowired
    private NewDobRepository newDobRepository;

    // Save a new DOB record
    public NewDob saveNewDob(NewDob newDob) {
        return newDobRepository.save(newDob);
    }

    // Get all DOB records
    public List<NewDob> getAllDobs() {
        return newDobRepository.findAll();
    }

    // Find a DOB record by ID
    public Optional<NewDob> getDobById(Long id) {
        return newDobRepository.findById(id);
    }

    // Delete a DOB record by ID
    public void deleteDobById(Long id) {
        newDobRepository.deleteById(id);
    }
}
