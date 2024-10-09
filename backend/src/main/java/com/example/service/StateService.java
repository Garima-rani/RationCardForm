//package com.example.service;
//
//import com.example.model.Language;
//
//import com.example.model.States;
//import com.example.repository.LanguageRepository;
//import com.example.repository.StatesRepository;
//
//import jakarta.persistence.EntityNotFoundException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class StateService {
//
//    @Autowired
//    private StatesRepository statesRepository;
//
//    @Autowired
//    private LanguageRepository languageRepository;
//
//    // Fetch all states
//    public List<States> getAllStates() {
//        return statesRepository.findAll();
//    }
//
//    // Fetch languages mapped to a state by state id
//    public List<String> getLanguagesByStateId(Long stateId) {
//        Optional<States> state = statesRepository.findById(stateId);
//        if (state.isPresent()) {
//            Set<Language> languages = state.get().getLanguages();
//            return languages.stream().map(Language::getLanguageName).collect(Collectors.toList());
//        } else {
//            throw new EntityNotFoundException("State with id " + stateId + " not found");
//        }
//    }
//
//    // Create a new state
//    public States createState(States state) {
//        return statesRepository.save(state);
//    }
//
//    // Update an existing state
//    public States updateState(Long id, States updatedState) {
//        States state = statesRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("State not found"));
//
//        state.setStateName(updatedState.getStateName());
//        state.setStateCode(updatedState.getStateCode());
//        state.setLocalName(updatedState.getLocalName());
//        state.setShortName(updatedState.getShortName());
//        state.setStateUnionTerritory(updatedState.getStateUnionTerritory());
//        state.setDbt(updatedState.getDbt());
//        state.setCentralProgramsState(updatedState.getCentralProgramsState());
//        state.setAvailableOnMobileApp(updatedState.getAvailableOnMobileApp());
//        state.setRcmsHostedOnNfsaPortal(updatedState.getRcmsHostedOnNfsaPortal());
//        state.setCommonRegistrationFacilityForRcAvailable(updatedState.getCommonRegistrationFacilityForRcAvailable());
//        state.setAvailableForFpsMobileSaleApp(updatedState.getAvailableForFpsMobileSaleApp());
//        state.setStatus(updatedState.getStatus());
//        state.setDescription(updatedState.getDescription());
//        return statesRepository.save(state);
//    }
//
//    // Delete a state
//    public void deleteState(Long id) {
//        statesRepository.deleteById(id);
//    }
//}
