package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.DropdownOption;
import com.example.repository.DropdownOptionRepository;

@Service
public class DropdownOptionService {

    @Autowired
    private DropdownOptionRepository dropdownOptionRepository;

   

    public void deleteDropdownOption(Long id) {
        dropdownOptionRepository.deleteById(id);
    }
}
