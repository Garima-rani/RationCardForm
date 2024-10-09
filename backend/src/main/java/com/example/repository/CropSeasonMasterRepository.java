package com.example.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.CropSeasonDTO;
import com.example.model.CropSeasonMaster;

@Repository
public interface CropSeasonMasterRepository extends JpaRepository<CropSeasonMaster, Long> {
	 Optional<CropSeasonMaster> findByCropSeasonCode(String cropSeasonCode);
	 
	 @Query("SELECT new com.example.model.CropSeasonDTO(c.id, c.cropSeasonName) FROM CropSeasonMaster c")
	    List<CropSeasonDTO> findAllCropSeasonsNames();
}

