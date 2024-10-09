package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.ModuleMaster;
import com.example.model.ModuleMasterDTO;

@Repository
public interface ModuleMasterRepository extends JpaRepository<ModuleMaster, Long> {
	 @Query("SELECT new com.example.model.ModuleMasterDTO(c.id, c.moduleName) FROM ModuleMaster c")
	    List<ModuleMasterDTO> findAllModuleNames();
}

