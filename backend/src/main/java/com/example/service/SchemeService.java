package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Scheme;
import com.example.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeService {

    @Autowired
    private SchemeRepository schemeRepository;

    // Fetch all schemes
    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }

    // Create a new scheme
    public Scheme createScheme(Scheme scheme) {
        return schemeRepository.save(scheme);
    }

    // Update an existing scheme by ID
    public Scheme updateScheme(Long id, Scheme scheme) {
        Scheme existingScheme = schemeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Scheme not found with id: " + id));
        existingScheme.setName(scheme.getName()); // assuming Scheme has a name field
        return schemeRepository.save(existingScheme);
    }

    // Delete a scheme by ID
    public void deleteScheme(Long id) {
        if (!schemeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Scheme not found with id: " + id);
        }
        schemeRepository.deleteById(id);
    }
}
