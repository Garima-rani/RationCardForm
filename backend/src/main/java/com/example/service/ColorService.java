package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Color;
import com.example.model.ColorDTO;
import com.example.model.CommodityFormDTO;
import com.example.repository.ColorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Optional<Color> getColorById(Long id) {
        return colorRepository.findById(id);
    }

    public Color createColor(Color color) {
        return colorRepository.save(color);
    }

    public Color updateColor(Long id, Color color) {
        color.setId(id);
        return colorRepository.save(color);
    }

    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }

    // New method to get all color names
//    public List<String> getAllColorNames() {
//        return colorRepository.findAll().stream()
//                .map(Color::getColorName)
//                .collect(Collectors.toList());
//    }
    public List<ColorDTO> getAllColorsNames() {
        return colorRepository.findAllColorsNames();
    }
    
}
