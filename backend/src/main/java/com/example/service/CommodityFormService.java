package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.CustomException;
import com.example.model.CommodityForm;
import com.example.model.CommodityFormDTO;
import com.example.repository.CommodityFormRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommodityFormService {

    @Autowired
    private CommodityFormRepository repository;

    public List<CommodityForm> getAllCommodityForms() {
        return repository.findAll();
    }

    public CommodityForm createCommodityForm(CommodityForm commodityForm) {
        // Ensure commodityFormCode is set
        if (commodityForm.getCommodityFormCode() == null) {
            throw new CustomException("Commodity form code cannot be null.");
        }
        commodityForm.setFeedDate(LocalDate.now());
        // Check if commodityFormName already exists
        if (repository.existsByCommodityFormName(commodityForm.getCommodityFormName())) {
            throw new CustomException("Commodity form with this name already exists.");
        }
        
        commodityForm.setFeedDate(LocalDate.now());
        return repository.save(commodityForm);
    }

    public CommodityForm updateCommodityForm(Long id, CommodityForm commodityForm) {
        // Check if commodityFormName already exists (ignoring the current entity)
        CommodityForm existingForm = repository.findById(id).orElseThrow(() -> new CustomException("Commodity form not found."));
        if (!existingForm.getCommodityFormName().equals(commodityForm.getCommodityFormName()) 
                && repository.existsByCommodityFormName(commodityForm.getCommodityFormName())) {
            throw new CustomException("Commodity form with this name already exists.");
        }
        
        commodityForm.setCommodityFormCode(id);
        return repository.save(commodityForm);
    }
    public void deleteCommodityForm(Long id) {
        repository.deleteById(id);
    }
    public List<String> getAllCommodityFormNames() {
        List<CommodityForm> commodityForms = repository.findAll();
        return commodityForms.stream()
                .map(CommodityForm::getCommodityFormName) // Get the commodity form name
                .collect(Collectors.toList()); // Collect into a list
    }

    public CommodityForm getCommodityFormById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public List<CommodityFormDTO> getAllCommodityNames() {
        return repository.findAllCommodityFormNames();
    }
}
