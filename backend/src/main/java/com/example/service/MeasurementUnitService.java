package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ColorDTO;
import com.example.model.CommodityForm;
import com.example.model.CommodityFormDTO;
import com.example.model.CommodityGroupDTO;
import com.example.model.CommodityMaster;
import com.example.model.CommodityMasterFullDTO;
import com.example.model.CropSeasonDTO;
import com.example.model.Language;
import com.example.model.LanguageDTO;
import com.example.model.MeasurementUnit;
import com.example.model.MeasurementUnitDTO;
import com.example.model.MeasurementUnitFullDTO;
import com.example.model.ModuleMasterDTO;
import com.example.model.StateDto;
import com.example.model.States;
import com.example.repository.CommodityFormRepository;
import com.example.repository.LanguageRepository;
import com.example.repository.MeasurementUnitRepository;
import com.example.repository.StatesRepository;

@Service
public class MeasurementUnitService {

    @Autowired
    private MeasurementUnitRepository measurementUnitRepository;

    @Autowired
    private StatesRepository statesRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CommodityFormRepository commodityFormRepository;

    // Fetch all measurement units
    public List<MeasurementUnit> getAllMeasurementUnits() {
        List<MeasurementUnit> units = measurementUnitRepository.findAll();
        return units;
    }
    
    public MeasurementUnit updateMeasurementUnit(Long id, MeasurementUnit updatedUnit) {
        Optional<MeasurementUnit> existingUnitOptional = measurementUnitRepository.findById(id);

        if (existingUnitOptional.isPresent()) {
            MeasurementUnit existingUnit = existingUnitOptional.get();

            // Update fields
            existingUnit.setMeasurementUnitName(updatedUnit.getMeasurementUnitName());
            existingUnit.setMeasurementUnitShortName(updatedUnit.getMeasurementUnitShortName());
            existingUnit.setMeasurementUnitLocalName(updatedUnit.getMeasurementUnitLocalName());
            existingUnit.setDecimalPrecision(updatedUnit.getDecimalPrecision());
            existingUnit.setRemarks(updatedUnit.getRemarks());
            existingUnit.setStatus(updatedUnit.getStatus());
            existingUnit.setFeedBy(updatedUnit.getFeedBy());

            // Update associations (state, language, commodity form)
            if (updatedUnit.getStates() != null) {
                States state = updatedUnit.getStates();
                if (state.getId() == null) {
                    state = statesRepository.save(state);
                }
                existingUnit.setStates(state);
            }

            if (updatedUnit.getLanguage() != null) {
                Language language = updatedUnit.getLanguage();
                if (language.getId() == null) {
                    language = languageRepository.save(language);
                }
                existingUnit.setLanguage(language);
            }

            if (updatedUnit.getCommodityForm() != null) {
                CommodityForm commodityForm = updatedUnit.getCommodityForm();
                existingUnit.setCommodityForm(commodityForm);
            }

            // Save the updated measurement unit
            return measurementUnitRepository.save(existingUnit);
        } else {
            throw new RuntimeException("Measurement unit with id " + id + " not found");
        }
    }

    // Delete a measurement unit by ID
    public void deleteMeasurementUnit(Long id) {
        if (measurementUnitRepository.existsById(id)) {
            measurementUnitRepository.deleteById(id);
        } else {
            throw new RuntimeException("Measurement unit with id " + id + " not found");
        }
    }

    // Create a new measurement unit
    public MeasurementUnit createMeasurementUnit(MeasurementUnit measurementUnit) {
        // ... your existing logic ...

        // If state or language are transient, save them
        States state = measurementUnit.getStates();
        if (state.getId() == null) {
            state = statesRepository.save(state);
        }

        Language language = measurementUnit.getLanguage();
        if (language.getId() == null) {
            language = languageRepository.save(language);
        }

        measurementUnit.setStates(state);
        measurementUnit.setLanguage(language);

        return measurementUnitRepository.save(measurementUnit);
    }

    // Fetch all states for dropdown
    public List<States> getAllStates() {
        return statesRepository.findAll(); // Fetch all states from the repository
    }
//    public MeasurementUnitDTO convertToDTO(MeasurementUnit measurementUnit) {
//        String stateName = null;
//        String languageName = null;
//        String commodityFormName = null;
//
//        if (measurementUnit.getStates() != null) {
//            stateName = measurementUnit.getStates().getStateName();
//        }
//
//        if (measurementUnit.getLanguage() != null) {
//            languageName = measurementUnit.getLanguage().getLanguageName();
//        }
//
//        if (measurementUnit.getCommodityForm() != null) {
//            commodityFormName = measurementUnit.getCommodityForm().getCommodityFormName(); // Assuming `getFormName()`
//                                                                                           // is the correct method
//        }
//
//        return new MeasurementUnitDTO(
//                measurementUnit.getId(),
//                measurementUnit.getMeasurementUnitName(),
//                measurementUnit.getMeasurementUnitShortName(),
//                measurementUnit.getMeasurementUnitLocalName(),
//                measurementUnit.getDecimalPrecision(),
//                measurementUnit.getRemarks(),
//                measurementUnit.getStatus(),
//                measurementUnit.getFeedBy(),
//                measurementUnit.getFeedDate(),
//                commodityFormName,
//                stateName,
//                languageName);
//    }

    // Fetch languages by state ID for dropdown
//    public List<Language> getLanguagesByStateId(Long stateId) {
//        return languageRepository.findLanguagesByStateId(stateId);
//    }
    public List<LanguageDTO> getLanguagesByStateId(Long stateId) {
        List<Language> languages = languageRepository.findLanguagesByStateId(stateId);
        return languages.stream()
                .map(language -> new LanguageDTO(language.getId(), language.getLanguageName()))
                .collect(Collectors.toList());
    }
    

    public List<CommodityFormDTO> getAllCommodityNames() {
        return commodityFormRepository.findAllCommodityFormNames();
    }
    public List<MeasurementUnitDTO> getAllMeasurementUnitNames() {
        return measurementUnitRepository.findAllMeasurementUnitNames();
    }
    

public List<MeasurementUnitFullDTO> getAllMeasurementsOnly() {
    List<MeasurementUnit> masters = measurementUnitRepository.findAll();
    return masters.stream()
        .map(master -> new MeasurementUnitFullDTO(
        		master.getId(),
        		master.getMeasurementUnitName(),
        		master.getMeasurementUnitShortName(),
        		master.getMeasurementUnitLocalName(),
        		master.getDecimalPrecision(),
        		master.getRemarks(),
        		master.getStatus(),
        		master.getFeedBy(),
        		master.getFeedDate(),
        		new CommodityFormDTO(master.getCommodityForm().getId(),master.getCommodityForm().getCommodityFormName()),
        		new StateDto(master.getStates().getId(),master.getStates().getStateName()),
        		new LanguageDTO(master.getLanguage().getId(),master.getLanguage().getLanguageName())     	    		
        		))
        .collect(Collectors.toList());
}
    
}
