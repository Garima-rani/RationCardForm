package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Nationality;
import com.example.repository.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalityService {

    @Autowired
    private NationalityRepository nationalityRepository;

    // Fetch all nationalities
    public List<Nationality> getAllNationalities() {
        return nationalityRepository.findAll();
    }

    // Create a new nationality
    public Nationality createNationality(Nationality nationality) {
        return nationalityRepository.save(nationality);
    }

    // Update an existing nationality by ID
    public Nationality updateNationality(Long id, Nationality nationality) {
        Nationality existingNationality = nationalityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nationality not found with id: " + id));
        existingNationality.setName(nationality.getName());
        return nationalityRepository.save(existingNationality);
    }

    // Delete a nationality by ID
    public void deleteNationality(Long id) {
        if (!nationalityRepository.existsById(id)) {
            throw new ResourceNotFoundException("Nationality not found with id: " + id);
        }
        nationalityRepository.deleteById(id);
    }
}
