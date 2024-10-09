package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.CommodityFormDTO;
import com.example.model.CommodityMasterFullDTO;
import com.example.model.LanguageDTO;
import com.example.model.MeasurementUnit;
import com.example.model.MeasurementUnitDTO;
import com.example.model.MeasurementUnitFullDTO;
import com.example.model.ModuleMasterDTO;
import com.example.model.StateDto;
import com.example.service.CommodityFormService;
import com.example.service.MeasurementUnitService;

@RestController
@RequestMapping("/api/measurement-units")
public class MeasurementUnitController {

    @Autowired
    private MeasurementUnitService measurementUnitService;
    
    @Autowired CommodityFormService service;
    
    @GetMapping("/full")
    public ResponseEntity<List<MeasurementUnit>> getAllMeasurementUnits() {
        List<MeasurementUnit> units = measurementUnitService.getAllMeasurementUnits();
        return new ResponseEntity<>(units, HttpStatus.OK);
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<MeasurementUnit> getMeasurementUnitById(@PathVariable Long id) {
//        MeasurementUnit unit = measurementUnitService.getMeasurementUnitById(id);  // Make sure to create this method in your service layer
//        return new ResponseEntity<>(unit, HttpStatus.OK);
//    }

    // Create a new Measurement Unit
    @PostMapping
    public ResponseEntity<MeasurementUnit> createMeasurementUnit(@RequestBody MeasurementUnit measurementUnit) {
        MeasurementUnit createdUnit = measurementUnitService.createMeasurementUnit(measurementUnit);
        return new ResponseEntity<>(createdUnit, HttpStatus.CREATED);
    }

    // Fetch states for dropdown
    @GetMapping("/states")
    public ResponseEntity<List<StateDto>> getAllStates() {
        List<StateDto> states = measurementUnitService.getAllStates().stream()
            .map(state -> new StateDto(state.getId(), state.getStateName())) // Create StateDTO for each state
            .collect(Collectors.toList());
        
        return ResponseEntity.ok(states);
    }

    @GetMapping("/languages/{stateId}")
    public ResponseEntity<List<LanguageDTO>> getLanguagesByStateId(@PathVariable Long stateId) {
        List<LanguageDTO> languages = measurementUnitService.getLanguagesByStateId(stateId);
        return ResponseEntity.ok(languages);
    }

    // Fetch commodity form names
    @GetMapping("/names")
    public List<MeasurementUnitDTO> getAllMeasurementUnitNames() {
        return measurementUnitService.getAllMeasurementUnitNames();
    }
    @PutMapping("/{id}")
    public ResponseEntity<MeasurementUnit> updateMeasurementUnit(@PathVariable Long id, @RequestBody MeasurementUnit measurementUnit) {
        MeasurementUnit updatedUnit = measurementUnitService.updateMeasurementUnit(id, measurementUnit);  // Make sure to create this method in your service layer
        return new ResponseEntity<>(updatedUnit, HttpStatus.OK);
    }

    // Delete Measurement Unit by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurementUnit(@PathVariable Long id) {
        measurementUnitService.deleteMeasurementUnit(id);  // Make sure to create this method in your service layer
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping
    public ResponseEntity<List<MeasurementUnitFullDTO>> getAllMeasurementsOnly() {
        List<MeasurementUnitFullDTO> masters = measurementUnitService.getAllMeasurementsOnly();
        return new ResponseEntity<>(masters, HttpStatus.OK);
    }
}
