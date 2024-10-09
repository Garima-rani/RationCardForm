package com.example.repository;

import com.example.model.CommodityForm;
import com.example.model.CommodityGroupDTO;
import com.example.model.CommodityGroups;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommodityGroupRepository extends JpaRepository<CommodityGroups, Long> {

	 @Query("SELECT new com.example.model.CommodityGroupDTO(c.id, c.groupName) FROM CommodityGroups c")
	    List<CommodityGroupDTO> findAllCommodityGroupNames();
	 @Query("SELECT new com.example.model.CommodityGroups(g.id, g.groupCode, g.groupName, g.nameLocal, g.shortName, g.feedBy, g.feedDate, g.status, g.remarks) FROM CommodityGroups g")
	    List<CommodityGroups> findAllBasicCommodityGroups();
    // Additional query methods can be defined here if needed
}
