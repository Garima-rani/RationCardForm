package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.MaritalStatus;
import com.example.repository.MaritalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaritalStatusService {

    @Autowired
    private MaritalStatusRepository maritalStatusRepository;

    // Fetch all marital statuses
    public List<MaritalStatus> getAllMaritalStatuses() {
        return maritalStatusRepository.findAll();
    }

    // Redundant method removed, the above method handles this.
    // public List<MaritalStatus> getAllMaritalStatus() { 
    //    return maritalStatusRepository.findAll();
    // }

    // Create a new marital status
    public MaritalStatus createMaritalStatus(MaritalStatus maritalStatus) {
        return maritalStatusRepository.save(maritalStatus);
    }

    // Update an existing marital status by ID
    public MaritalStatus updateMaritalStatus(Long id, MaritalStatus maritalStatus) {
        MaritalStatus existingMaritalStatus = maritalStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MaritalStatus not found with id: " + id));
        existingMaritalStatus.setName(maritalStatus.getName());
        return maritalStatusRepository.save(existingMaritalStatus);
    }

    // Delete a marital status by ID
    public void deleteMaritalStatus(Long id) {
        if (!maritalStatusRepository.existsById(id)) {
            throw new ResourceNotFoundException("MaritalStatus not found with id: " + id);
        }
        maritalStatusRepository.deleteById(id);
    }
}
