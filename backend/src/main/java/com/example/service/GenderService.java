package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Gender;
import com.example.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    // Fetch all genders
    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }

    // Create a new gender
    public Gender createGender(Gender gender) {
        return genderRepository.save(gender);
    }

    // Update an existing gender by ID
    public Gender updateGender(Long id, Gender gender) {
        Gender existingGender = genderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gender not found with id: " + id));
        existingGender.setName(gender.getName());
        return genderRepository.save(existingGender);
    }

    // Delete a gender by ID
    public void deleteGender(Long id) {
        if (!genderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Gender not found with id: " + id);
        }
        genderRepository.deleteById(id);
    }
}
