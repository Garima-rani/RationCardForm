package com.example.service;

import com.example.model.Occupation;
import com.example.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccupationService {

    @Autowired
    private OccupationRepository occupationRepository;

    // Create a new Occupation
    public Occupation createOccupation(Occupation occupation) {
        return occupationRepository.save(occupation);
    }

    // Get all Occupations
    public List<Occupation> getAllOccupations() {
        return occupationRepository.findAll();
    }

    // Get Occupation by id
    public Optional<Occupation> getOccupationById(Long id) {
        return occupationRepository.findById(id);
    }

    // Update Occupation by id
    public Optional<Occupation> updateOccupation(Long id, Occupation occupationDetails) {
        Optional<Occupation> occupation = occupationRepository.findById(id);
        if (occupation.isPresent()) {
            Occupation existingOccupation = occupation.get();
            existingOccupation.setName(occupationDetails.getName());
            existingOccupation.setNameLocal(occupationDetails.getNameLocal());
            existingOccupation.setShortName(occupationDetails.getShortName());
            existingOccupation.setDate(occupationDetails.getDate());
            existingOccupation.setFeedBy(occupationDetails.getFeedBy());
            existingOccupation.setStatus(occupationDetails.getStatus());
            return Optional.of(occupationRepository.save(existingOccupation));
        } else {
            return Optional.empty();
        }
    }

    // Delete Occupation by id
    public boolean deleteOccupation(Long id) {
        Optional<Occupation> occupation = occupationRepository.findById(id);
        if (occupation.isPresent()) {
            occupationRepository.delete(occupation.get());
            return true;
        } else {
            return false;
        }
    }
}
