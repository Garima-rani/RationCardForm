
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CommodityGroupDTO;
import com.example.model.Language;
import com.example.model.LanguageDTO;
import com.example.service.LanguageService;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    // Fetch all languages
    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    // Fetch states mapped to a language by language id
    @GetMapping("/{id}/states")
    public List<String> getStateNamesByLanguageId(@PathVariable Long id) {
        return languageService.getStateNamesByLanguageId(id);
    }

    // Create a new language
    @PostMapping
    public Language createLanguage(@RequestBody Language language) {
        return languageService.createLanguage(language);
    }

    // Update an existing language
    @PutMapping("/{id}")
    public Language updateLanguage(@PathVariable Long id, @RequestBody Language language) {
        return languageService.updateLanguage(id, language);
    }

    // Delete a language
    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(id);
    }
    
    @GetMapping("/names")
    public List<LanguageDTO> getAllLanguageNames() {
        return languageService.getAllLanguageNames();
    }
}
