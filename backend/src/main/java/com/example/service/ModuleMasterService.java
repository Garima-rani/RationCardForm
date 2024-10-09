package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.CommodityFormDTO;
import com.example.model.ModuleMaster;
import com.example.model.ModuleMasterDTO;
import com.example.repository.ModuleMasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleMasterService {

    @Autowired
    private ModuleMasterRepository moduleMasterRepository;

    // Create or Update a module
    public ModuleMaster saveModule(ModuleMaster module) {
        return moduleMasterRepository.save(module);
    }

    // Get all modules
    public List<ModuleMaster> getAllModules() {
        return moduleMasterRepository.findAll();
    }

    // Get a module by ID
    public Optional<ModuleMaster> getModuleById(Long id) {
        return moduleMasterRepository.findById(id);
    }

    // Delete a module by ID
    public void deleteModuleById(Long id) {
        moduleMasterRepository.deleteById(id);
    }
    
    public List<ModuleMasterDTO> getAllModuleNames() {
        return moduleMasterRepository.findAllModuleNames();
    }
}

