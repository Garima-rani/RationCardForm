package com.example.service;

import com.example.model.NewLocalUsername;
import com.example.repository.NewLocalUsernameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewLocalUsernameService {

    @Autowired
    private NewLocalUsernameRepository newLocalUsernameRepository;

    // Save a new local username record
    public NewLocalUsername saveNewLocalUsername(NewLocalUsername newLocalUsername) {
        return newLocalUsernameRepository.save(newLocalUsername);
    }

    // Get all local username records
    public List<NewLocalUsername> getAllLocalUsernames() {
        return newLocalUsernameRepository.findAll();
    }

    // Find a local username record by ID
    public Optional<NewLocalUsername> getLocalUsernameById(Long id) {
        return newLocalUsernameRepository.findById(id);
    }

    // Delete a local username record by ID
    public void deleteLocalUsernameById(Long id) {
        newLocalUsernameRepository.deleteById(id);
    }
}
