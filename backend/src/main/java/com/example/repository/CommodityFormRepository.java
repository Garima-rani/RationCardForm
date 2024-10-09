package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.CommodityForm;
import com.example.model.CommodityFormDTO;

@Repository
public interface CommodityFormRepository extends JpaRepository<CommodityForm, Long> {
	  boolean existsByCommodityFormName(String commodityFormName);
	  // This method will fetch all commodity_form_name values
//	  @Query("SELECT c.commodityFormName FROM CommodityForm c")
//	    List<String> findAllCommodityFormNames();
	  
	  @Query("SELECT new com.example.model.CommodityFormDTO(c.id, c.commodityFormName) FROM CommodityForm c")
	    List<CommodityFormDTO> findAllCommodityFormNames();
}

