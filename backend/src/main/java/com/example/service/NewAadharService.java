package com.example.service;

import com.example.model.New_Aadhar;
import com.example.repository.NewAadharRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewAadharService {

    @Autowired
    private NewAadharRepository newAadharRepository;

    // Save a new Aadhar record
    public New_Aadhar saveNewAadhar(New_Aadhar newAadhar) {
        return newAadharRepository.save(newAadhar);
    }

    // Get all Aadhar records
    public List<New_Aadhar> getAllAadharRecords() {
        return newAadharRepository.findAll();
    }

    // Find an Aadhar record by ID
    public Optional<New_Aadhar> getAadharById(Long id) {
        return newAadharRepository.findById(id);
    }

    // Delete an Aadhar record by ID
    public void deleteAadharById(Long id) {
        newAadharRepository.deleteById(id);
    }
}
