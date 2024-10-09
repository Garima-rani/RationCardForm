package com.example.service;

import com.example.model.NewLocalFathername;
import com.example.repository.NewLocalFathernameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewLocalFathernameService {

    @Autowired
    private NewLocalFathernameRepository newLocalFathernameRepository;

    // Save a new local father name record
    public NewLocalFathername saveNewLocalFathername(NewLocalFathername newLocalFathername) {
        return newLocalFathernameRepository.save(newLocalFathername);
    }

    // Get all local father name records
    public List<NewLocalFathername> getAllLocalFathernames() {
        return newLocalFathernameRepository.findAll();
    }

    // Find a local father name record by ID
    public Optional<NewLocalFathername> getLocalFathernameById(Long id) {
        return newLocalFathernameRepository.findById(id);
    }

    // Delete a local father name record by ID
    public void deleteLocalFathernameById(Long id) {
        newLocalFathernameRepository.deleteById(id);
    }
}
