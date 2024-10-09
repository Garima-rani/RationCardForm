package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Color;
import com.example.model.ColorDTO;

public interface ColorRepository extends JpaRepository<Color, Long> {
	
	 @Query("SELECT new com.example.model.ColorDTO(c.id, c.colorName) FROM Color c")
	    List<ColorDTO> findAllColorsNames();
}

