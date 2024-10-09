package com.example.service;

import com.example.model.NewMobileNo;
import com.example.repository.NewMobileNoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewMobileNoService {

    @Autowired
    private NewMobileNoRepository newMobileNoRepository;

    // Save a new mobile number record
    public NewMobileNo saveNewMobileNo(NewMobileNo newMobileNo) {
        return newMobileNoRepository.save(newMobileNo);
    }

    // Get all mobile number records
    public List<NewMobileNo> getAllNewMobileNos() {
        return newMobileNoRepository.findAll();
    }

    // Find a mobile number record by ID
    public Optional<NewMobileNo> getNewMobileNoById(Long id) {
        return newMobileNoRepository.findById(id);
    }

    // Delete a mobile number record by ID
    public void deleteNewMobileNoById(Long id) {
        newMobileNoRepository.deleteById(id);
    }
}
