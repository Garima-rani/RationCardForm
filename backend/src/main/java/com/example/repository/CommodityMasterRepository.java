package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.CommodityGroups;
import com.example.model.CommodityMaster;


@Repository
public interface CommodityMasterRepository extends JpaRepository<CommodityMaster, Long> {

	 // Query to find the max commodity code where the first two digits match the group code and the last two digits are '00'
//    @Query("SELECT MAX(c.commodityCode) FROM CommodityMaster c WHERE LEFT(c.commodityCode, 2) = :groupCode AND RIGHT(c.commodityCode, 2) = '00'")
//    String findMaxCommodityCodeForGroupWithSuffix00(String groupCode);
//
//    // Query to find the max commodity code where the first four digits match
//    @Query("SELECT MAX(c.commodityCode) FROM CommodityMaster c WHERE LEFT(c.commodityCode, 4) = :groupPrefix")
//    String findMaxCommodityCodeForGroupPrefix(String groupPrefix);
//    
//    // Find major commodities in a commodity group
//   
//     List<CommodityMaster> findByCommodityGroupAndIsMajor(Long commodityGroupId, boolean isMajor);
//
//    // Find sub-commodities under a major commodity
//    List<CommodityMaster> findByMajorCommodityId(Integer majorCommodityId);
//    
//    // Method to fetch all major commodities (where isUnderMajorCommodity is false)
//    List<CommodityMaster> findByIsUnderMajorCommodityFalse();
//    long countByIsUnderMajorCommodityFalse();
//    long countByMajorCommodity_CommodityCode(String majorCommodityCode);
//    long countByIsMajor(boolean isMajor);
//    
    Long countByCommodityGroupAndIsUnderMajorCommodityFalse(CommodityGroups commodityGroup);

    Long countByCommodityGroupAndIsUnderMajorCommodityTrueAndMajorCommodity(CommodityGroups commodityGroup, CommodityMaster majorCommodity);

}
