package com.example.service;

import com.example.model.NewNationality;
import com.example.repository.NewNationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewNationalityService {

    @Autowired
    private NewNationalityRepository newNationalityRepository;

    // Save a new nationality record
    public NewNationality saveNewNationality(NewNationality newNationality) {
        return newNationalityRepository.save(newNationality);
    }

    // Get all nationality records
    public List<NewNationality> getAllNewNationalities() {
        return newNationalityRepository.findAll();
    }

    // Find a nationality record by ID
    public Optional<NewNationality> getNewNationalityById(Long id) {
        return newNationalityRepository.findById(id);
    }

    // Delete a nationality record by ID
    public void deleteNewNationalityById(Long id) {
        newNationalityRepository.deleteById(id);
    }
}
