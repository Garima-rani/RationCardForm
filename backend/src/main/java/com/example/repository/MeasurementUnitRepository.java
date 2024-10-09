package com.example.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.model.MeasurementUnit;
import com.example.model.MeasurementUnitDTO;


public interface MeasurementUnitRepository extends JpaRepository<MeasurementUnit, Long> {
	
    @Query("SELECT mu FROM MeasurementUnit mu JOIN FETCH mu.state JOIN FETCH mu.language WHERE mu.id = :id")
    Optional<MeasurementUnit> findByIdWithStateAndLanguage(@Param("id") Long id); 
    
    @Query("SELECT new com.example.model.MeasurementUnitDTO(c.id, c.measurementUnitName) FROM MeasurementUnit c")
    List<MeasurementUnitDTO> findAllMeasurementUnitNames();

}
