package com.example.repository;

import com.example.model.MasterData; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterDataRepository extends JpaRepository<MasterData, Long> {

    List<MasterData> findByType(String type);
    
}
