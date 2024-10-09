package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.CropSeasonDTO;
import com.example.model.CropSeasonMaster;
import com.example.service.CropSeasonMasterService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cropseasons")
public class CropSeasonMasterController {

    @Autowired
    private CropSeasonMasterService service;

    // Create or Update Crop Season
    @PostMapping
    public ResponseEntity<CropSeasonMaster> createOrUpdateCropSeason(@RequestBody CropSeasonMaster cropSeason) {
        CropSeasonMaster savedCropSeason = service.saveCropSeason(cropSeason);
        return ResponseEntity.ok(savedCropSeason);
    }

    // Get all Crop Seasons
    @GetMapping
    public ResponseEntity<List<CropSeasonMaster>> getAllCropSeasons() {
        List<CropSeasonMaster> cropSeasons = service.getAllCropSeasons();
        return ResponseEntity.ok(cropSeasons);
    }

    // Get Crop Season by ID
    @GetMapping("/{id}")
    public ResponseEntity<CropSeasonMaster> getCropSeasonById(@PathVariable("id") Long cropSeasonCode) {
        Optional<CropSeasonMaster> cropSeason = service.getCropSeasonById(cropSeasonCode);
        return cropSeason.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Crop Season by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCropSeasonById(@PathVariable("id") Long cropSeasonCode) {
        service.deleteCropSeasonById(cropSeasonCode);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/names")
    public List<CropSeasonDTO> getAllCropSeasonsNames() {
        return service.getAllCropSeasonsNames();
    }
}
