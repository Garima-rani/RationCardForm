package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Color;
import com.example.model.ColorDTO;
import com.example.service.ColorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping
    public List<Color> getAllColors() {
        return colorService.getAllColors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getColorById(@PathVariable Long id) {
        Optional<Color> color = colorService.getColorById(id);
        return color.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Color createColor(@RequestBody Color color) {
        return colorService.createColor(color);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> updateColor(@PathVariable Long id, @RequestBody Color color) {
        return ResponseEntity.ok(colorService.updateColor(id, color));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable Long id) {
        colorService.deleteColor(id);
        return ResponseEntity.noContent().build();
    }

    // New endpoint to get all color names
    @GetMapping("/names")
    public List<ColorDTO> getAllColorsNames() {
        return colorService.getAllColorsNames();
    }
}
