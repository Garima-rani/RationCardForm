package com.example.service;

import com.example.model.CategoryDTO;
import com.example.model.Language;
import com.example.model.LanguageDTO;
import com.example.model.OwnershipTypeDTO;
import com.example.model.ProcurementTypeDTO;
import com.example.model.StateFullDto;
import com.example.model.StateWithLanguagesDto;
import com.example.model.States;
import com.example.repository.LanguageRepository;
import com.example.repository.StatesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StatesService {

    @Autowired
    private StatesRepository statesRepository;

    @Autowired
    private LanguageRepository languageRepository;

    // Fetch all states
    public List<States> getAllStates() {
        return statesRepository.findAll();
    }

    // Fetch languages mapped to a state by state id
    public List<String> getLanguagesByStateId(Long stateId) {
        Optional<States> state = statesRepository.findById(stateId);
        if (state.isPresent()) {
            Set<Language> languages = state.get().getLanguages();
            return languages.stream().map(Language::getLanguageName).collect(Collectors.toList());
        } else {
            throw new EntityNotFoundException("State with id " + stateId + " not found");
        }
    }

    // Create a new state
    public States createState(States state) {
        return statesRepository.save(state);
    }
    
    public List<StateFullDto> getAllStatesOnly() {
        List<States> states = statesRepository.findAll();
        return states.stream()
            .map(state -> new StateFullDto(
                state.getId(),
                state.getStateName(),
                state.getStateCode(),
                state.getLocalName(),
                state.getShortName(),
                state.getStateUnionTerritory(),
                state.getDbt(),
                state.getDocument(),
                state.getCentralProgramsState(),
                state.getAvailableOnMobileApp(),
                state.getRcmsHostedOnNfsaPortal(),
                state.getCommonRegistrationFacilityForRcAvailable(),
                state.getAvailableForFpsMobileSaleApp(),
                state.getStatus(),
                state.getDescription(),            
                new ProcurementTypeDTO(state.getProcurementType().getId(), state.getProcurementType().getName()),
                new CategoryDTO(state.getCategory().getId(), state.getCategory().getName()),
                new OwnershipTypeDTO(state.getOwnershipType().getId(), state.getOwnershipType().getName())
            ))
            .collect(Collectors.toList());
    }

    public List<StateWithLanguagesDto> getStatesWithLanguages() {
        List<States> states = statesRepository.findAll();
        return states.stream()
            .map(state -> new StateWithLanguagesDto(
                state.getId(),
                state.getStateName(),
                state.getLanguages().stream()
                    .map(lang -> new LanguageDTO(lang.getId(), lang.getLanguageName()))
                    .collect(Collectors.toList())
            ))
            .collect(Collectors.toList());
    }

    // Update an existing state
    public States updateState(Long id, States updatedState, MultipartFile file) {
        States state = statesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("State not found"));

        state.setStateName(updatedState.getStateName());
        state.setStateCode(updatedState.getStateCode());
        state.setLocalName(updatedState.getLocalName());
        state.setShortName(updatedState.getShortName());
        state.setStateUnionTerritory(updatedState.getStateUnionTerritory());
        state.setDbt(updatedState.getDbt());
        state.setCentralProgramsState(updatedState.getCentralProgramsState());
        state.setAvailableOnMobileApp(updatedState.getAvailableOnMobileApp());
        state.setRcmsHostedOnNfsaPortal(updatedState.getRcmsHostedOnNfsaPortal());
        state.setCommonRegistrationFacilityForRcAvailable(updatedState.getCommonRegistrationFacilityForRcAvailable());
        state.setAvailableForFpsMobileSaleApp(updatedState.getAvailableForFpsMobileSaleApp());
        state.setStatus(updatedState.getStatus());
        state.setDescription(updatedState.getDescription());

        // Handle document file upload
        if (file != null && !file.isEmpty()) {
            try {
                state.setDocument(file.getBytes()); // Save the uploaded file as byte[]
            } catch (IOException e) {
                throw new RuntimeException("Error while uploading document", e);
            }
        }
        return statesRepository.save(state);
    }

    // Delete a state
    public void deleteState(Long id) {
        statesRepository.deleteById(id);
    }
    
    // Method to upload document
    public States uploadDocument(Long stateId, byte[] document) {
        States state = statesRepository.findById(stateId)
                .orElseThrow(() -> new EntityNotFoundException("State not found"));
        state.setDocument(document);
        return statesRepository.save(state);
    }

    // Method to retrieve document
    public byte[] getDocument(Long stateId) {
        States state = statesRepository.findById(stateId)
                .orElseThrow(() -> new EntityNotFoundException("State not found"));
        return state.getDocument();
    }
}
