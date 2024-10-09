package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.CommodityFormDTO;
import com.example.model.CropSeasonDTO;
import com.example.model.CropSeasonMaster;
import com.example.repository.CropSeasonMasterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CropSeasonMasterService {

    @Autowired
    private CropSeasonMasterRepository repository;

    // Create or Update a Crop Season
    public CropSeasonMaster saveCropSeason(CropSeasonMaster cropSeason) {
        return repository.save(cropSeason);
    }

    // Get all Crop Seasons
    public List<CropSeasonMaster> getAllCropSeasons() {
        return repository.findAll();
    }

    // Get a Crop Season by ID
    public Optional<CropSeasonMaster> getCropSeasonById(Long cropSeasonCode) {
        return repository.findById(cropSeasonCode);
    }
    public Optional<CropSeasonMaster> getCropSeasonByCode(String cropSeasonCode) {
        return repository.findByCropSeasonCode(cropSeasonCode);
    }

    // Delete a Crop Season
    public void deleteCropSeasonById(Long cropSeasonCode) {
        repository.deleteById(cropSeasonCode);
    }
    
    public List<CropSeasonDTO> getAllCropSeasonsNames() {
        return repository.findAllCropSeasonsNames();
    }
}
