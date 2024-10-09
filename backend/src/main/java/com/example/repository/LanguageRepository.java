package com.example.repository;

import com.example.model.CropSeasonDTO;
import com.example.model.Language;
import com.example.model.LanguageDTO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    // You can add custom query methods if needed
	 @Query("SELECT l FROM Language l JOIN l.states s WHERE s.id = :stateId")
	    List<Language> findLanguagesByStateId(Long stateId);
	 
	 @Query("SELECT new com.example.model.LanguageDTO(c.id, c.languageName) FROM Language c")
	    List<LanguageDTO> findAllLanguageNames();
	 
    }
