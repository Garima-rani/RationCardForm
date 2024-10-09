package com.example.service;

import com.example.model.CommodityFormDTO;
import com.example.model.CommodityGroupDTO;
import com.example.model.CommodityGroups;
import com.example.model.Language;
import com.example.model.MeasurementUnit;
import com.example.model.States;
import com.example.repository.CommodityGroupRepository;
import com.example.repository.LanguageRepository;
import com.example.repository.StatesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommodityGroupService {

    @Autowired
    private CommodityGroupRepository commodityGroupRepository;
    
    @Autowired
    private StatesRepository repository;
    
    @Autowired
    LanguageRepository repo;

    // Save commodity group with automatic feedBy and feedDate population
    public CommodityGroups save(CommodityGroups commodityGroup) {
        // Automatically set the feedBy field to the current username
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        commodityGroup.setFeedBy(currentUsername);

        // Automatically set the feedDate field to the current date
        commodityGroup.setFeedDate(LocalDate.now());

        // Save the commodity group to the repository
        return commodityGroupRepository.save(commodityGroup);
    }

    public List<CommodityGroups> getAllCommodityGroups() {
        return commodityGroupRepository.findAll();
    }

    public Optional<CommodityGroups> getCommodityGroupById(Long id) {
        return commodityGroupRepository.findById(id);
    }
    
    public CommodityGroups createCommodityGroup(CommodityGroups commodityGroup) {
        // ... your existing logic ...

        // If state or language are transient, save them
        States state = commodityGroup.getState();
        if (state.getId() == null) {
            state = repository.save(state);
        }

        Language language = commodityGroup.getLanguage();
        if (language.getId() == null) {
            language = repo.save(language);
        }

        commodityGroup.setState(state);
        commodityGroup.setLanguage(language);

        return commodityGroupRepository.save(commodityGroup);
    }

    public CommodityGroups updateCommodityGroup(Long id, CommodityGroups updatedGroup) {
        Optional<CommodityGroups> existingGroup = commodityGroupRepository.findById(id);
        if (existingGroup.isPresent()) {
            CommodityGroups group = existingGroup.get();
            group.setGroupCode(updatedGroup.getGroupCode());
            group.setGroupName(updatedGroup.getGroupName());
            group.setNameLocal(updatedGroup.getNameLocal());
            group.setShortName(updatedGroup.getShortName());
            group.setStatus(updatedGroup.getStatus());
            group.setRemarks(updatedGroup.getRemarks());
            group.setFeedBy(updatedGroup.getFeedBy());
            return commodityGroupRepository.save(group);
        } else {
            throw new RuntimeException("Commodity Group not found with id " + id);
        }
    }

    public void deleteCommodityGroup(Long id) {
        if (commodityGroupRepository.existsById(id)) {
            commodityGroupRepository.deleteById(id);
        } else {
            throw new RuntimeException("Commodity Group not found with id " + id);
        }
    }
    public List<CommodityGroupDTO> getAllCommodityGroupNames() {
        return commodityGroupRepository.findAllCommodityGroupNames();
    }
    public List<CommodityGroups> getBasicCommodityGroups() {
        // Fetch only basic fields without related entities
        return commodityGroupRepository.findAllBasicCommodityGroups();
    }
}
