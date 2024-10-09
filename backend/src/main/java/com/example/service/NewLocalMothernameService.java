package com.example.service;

import com.example.model.NewLocalMothername;
import com.example.repository.NewLocalMothernameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewLocalMothernameService {

    @Autowired
    private NewLocalMothernameRepository newLocalMothernameRepository;

    // Save a new local mother name record
    public NewLocalMothername saveNewLocalMothername(NewLocalMothername newLocalMothername) {
        return newLocalMothernameRepository.save(newLocalMothername);
    }

    // Get all local mother name records
    public List<NewLocalMothername> getAllLocalMothernames() {
        return newLocalMothernameRepository.findAll();
    }

    // Find a local mother name record by ID
    public Optional<NewLocalMothername> getLocalMothernameById(Long id) {
        return newLocalMothernameRepository.findById(id);
    }

    // Delete a local mother name record by ID
    public void deleteLocalMothernameById(Long id) {
        newLocalMothernameRepository.deleteById(id);
    }
}
