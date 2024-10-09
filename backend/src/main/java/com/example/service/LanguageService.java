package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Language;
import com.example.model.LanguageDTO;
// Ensure this is the correct import for your State model
import com.example.model.States;
import com.example.repository.LanguageRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    // Fetch all languages
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    // Fetch states mapped to a language by language id
    public List<String> getStateNamesByLanguageId(Long languageId) {
        Optional<Language> language = languageRepository.findById(languageId);
        if (language.isPresent()) {
            List<States> states = language.get().getStates();  // Ensure the type is List<State>
            return states.stream().map(States::getStateName).collect(Collectors.toList());
        } else {
            throw new EntityNotFoundException("Language with id " + languageId + " not found");
        }
    }

    // Create a new language
    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    // Update an existing language
    public Language updateLanguage(Long id, Language updatedLanguage) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Language not found"));

        language.setLanguageCode(updatedLanguage.getLanguageCode());
        language.setLanguageName(updatedLanguage.getLanguageName());
        language.setShortName(updatedLanguage.getShortName());
        language.setRemarks(updatedLanguage.getRemarks());
        language.setScript(updatedLanguage.getScript());
        language.setStatus(updatedLanguage.getStatus());
        return languageRepository.save(language);
    }

    // Delete a language
    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
    
    public List<LanguageDTO> getAllLanguageNames() {
        return languageRepository.findAllLanguageNames();
    }
}
