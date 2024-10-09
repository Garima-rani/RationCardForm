package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.ProcurementType;
import com.example.repository.ProcurementTypeRepository;

import java.util.List;

@Service
public class ProcurementTypeService {

    @Autowired
    private ProcurementTypeRepository procurementTypeRepository;

    public List<ProcurementType> getAllProcurementTypes() {
        return procurementTypeRepository.findAll();
    }

    public ProcurementType createProcurementType(ProcurementType procurementType) {
        return procurementTypeRepository.save(procurementType);
    }

    public ProcurementType updateProcurementType(Long id, ProcurementType procurementType) {
        procurementType.setId(id);
        return procurementTypeRepository.save(procurementType);
    }

    public void deleteProcurementType(Long id) {
        procurementTypeRepository.deleteById(id);
    }

    public ProcurementType getProcurementTypeById(Long procurementTypeId) {
        return procurementTypeRepository.findById(procurementTypeId)
            .orElseThrow(() -> new ResourceNotFoundException("Procurement Type not found with id: " + procurementTypeId));
    }
}
