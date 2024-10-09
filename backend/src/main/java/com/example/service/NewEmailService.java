package com.example.service;

import com.example.model.NewEmail;
import com.example.repository.NewEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewEmailService {

    @Autowired
    private NewEmailRepository newEmailRepository;

    // Save a new email record
    public NewEmail saveNewEmail(NewEmail newEmail) {
        return newEmailRepository.save(newEmail);
    }

    // Get all email records
    public List<NewEmail> getAllEmails() {
        return newEmailRepository.findAll();
    }

    // Find an email record by ID
    public Optional<NewEmail> getEmailById(Long id) {
        return newEmailRepository.findById(id);
    }

    // Delete an email record by ID
    public void deleteEmailById(Long id) {
        newEmailRepository.deleteById(id);
    }
}
