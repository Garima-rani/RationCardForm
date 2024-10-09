package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Color;
import com.example.model.ColorDTO;
import com.example.model.CommodityForm;
import com.example.model.CommodityFormDTO;
import com.example.model.CommodityGroupDTO;
import com.example.model.CommodityGroups;
import com.example.model.CommodityMaster;
import com.example.model.CommodityMasterFullDTO;
import com.example.model.CropSeasonDTO;
import com.example.model.CropSeasonMaster;
import com.example.model.MeasurementUnit;
import com.example.model.MeasurementUnitDTO;
import com.example.model.ModuleMaster;
import com.example.model.ModuleMasterDTO;
import com.example.repository.CommodityGroupRepository;
import com.example.repository.CommodityMasterRepository;

@Service
public class CommodityMasterService {

    @Autowired
    private CommodityMasterRepository commodityMasterRepository;
    
  
    
    @Autowired
    private CommodityGroupRepository commodityGroupsRepository;
    
    @Autowired
    public CommodityMasterService(CommodityMasterRepository commodityMasterRepository) {
        this.commodityMasterRepository = commodityMasterRepository;
    }

    // Add new commodity logic with DTO mapping and commodity code generation
//    public void addNewCommodity(CommodityMasterFullDTO commodityMasterFullDTO) {
//        CommodityMaster commodityMaster = new CommodityMaster();
//
//        // Set values from DTO to entity
//        commodityMaster.setCommodityName(commodityMasterFullDTO.getCommodityName());
//        commodityMaster.setCommodityLocalName(commodityMasterFullDTO.getCommodityLocalName());
//        commodityMaster.setCommodityShortName(commodityMasterFullDTO.getCommodityShortName());
//        commodityMaster.setRemarks(commodityMasterFullDTO.getRemarks());
//        commodityMaster.setStatus(commodityMasterFullDTO.getStatus());
//        commodityMaster.setFeedBy(commodityMasterFullDTO.getFeedBy());
//        commodityMaster.setFeedDate(commodityMasterFullDTO.getFeedDate());
//        commodityMaster.setDocument(commodityMasterFullDTO.getDocument());
//        commodityMaster.setModule(moduleMasterFromDTO(commodityMasterFullDTO.getModuleMaster()));
//        commodityMaster.setMeasurementUnit(measurementUnitFromDTO(commodityMasterFullDTO.getMeasurementUnit()));
//        commodityMaster.setCropSeason(cropSeasonFromDTO(commodityMasterFullDTO.getCropSeason()));
//        commodityMaster.setCommodityForm(commodityFormFromDTO(commodityMasterFullDTO.getCommodityForm()));
//        commodityMaster.setCommodityGroup(commodityGroupFromDTO(commodityMasterFullDTO.getCommodityGroup()));
//        commodityMaster.setColor(colorFromDTO(commodityMasterFullDTO.getColor()));
//
//        // Logic for major/minor commodity handling
//        if (commodityMasterFullDTO.getIsUnderMajorCommodity()) {
//            // This is a minor commodity
//            if (commodityMasterFullDTO.getMajorCommodityId() != null) {
//                // Fetch major commodity using the ID provided
//                CommodityMaster majorCommodity = commodityMasterRepository.findById(commodityMasterFullDTO.getMajorCommodityId())
//                    .orElseThrow(() -> new RuntimeException("Major Commodity not found"));
//
//                // Generate the minor commodity code based on the major commodity code
//                String majorCommodityCode = majorCommodity.getCommodityCode();
//                String minorCommodityCode = generateMinorCommodityCode(majorCommodityCode);
//
//                commodityMaster.setCommodityCode(minorCommodityCode);
//                commodityMaster.setMajorCommodity(majorCommodity);
//            } else {
//                throw new IllegalArgumentException("Major Commodity ID is required for minor commodities");
//            }
//        } else {
//            // This is a major commodity
//            String majorCommodityCode = generateMajorCommodityCode();
//            commodityMaster.setCommodityCode(majorCommodityCode);
//        }
//
//        // Save the commodity in the repository
//        commodityMasterRepository.save(commodityMaster);
//    }
//
//    // Generate a major commodity code (e.g., MAJ001, MAJ002, etc.)
//    private String generateMajorCommodityCode() {
//        long count = commodityMasterRepository.countByIsUnderMajorCommodityFalse();
//        return "MAJ" + String.format("%03d", count + 1); // E.g., MAJ001
//    }
//
//    // Generate a minor commodity code (e.g., MAJ001-01, MAJ001-02, etc.)
//    private String generateMinorCommodityCode(String majorCommodityCode) {
//        long count = commodityMasterRepository.countByMajorCommodity_CommodityCode(majorCommodityCode);
//        return majorCommodityCode + "-" + String.format("%02d", count + 1); // E.g., MAJ001-01
//    }

    // Utility methods to convert DTOs to entity objects

//    private ModuleMaster moduleMasterFromDTO(ModuleMasterDTO moduleMasterDTO) {
//        // Convert ModuleMasterDTO to ModuleMaster entity
//        ModuleMaster moduleMaster = new ModuleMaster();
//        moduleMaster.setModuleId(moduleMasterDTO.getModuleId());
//        moduleMaster.setModuleName(moduleMasterDTO.getModuleName());
//        return moduleMaster;
//    }
//
//    private MeasurementUnit measurementUnitFromDTO(MeasurementUnitDTO measurementUnitDTO) {
//        // Convert MeasurementUnitDTO to MeasurementUnit entity
//        MeasurementUnit measurementUnit = new MeasurementUnit();
//        measurementUnit.setId(measurementUnitDTO.getId());
//        measurementUnit.setMeasurementUnitName(measurementUnitDTO.getMeasurementUnitName());
//        return measurementUnit;
//    }
//
//    private CropSeasonMaster cropSeasonFromDTO(CropSeasonDTO cropSeasonDTO) {
//        // Convert CropSeasonDTO to CropSeason entity
//        CropSeasonMaster cropSeason = new CropSeasonMaster();
//        cropSeason.setId(cropSeasonDTO.getId());
//        cropSeason.setCropSeasonName(cropSeasonDTO.getCropSeasonName());
//        return cropSeason;
//    }

//    private CommodityForm commodityFormFromDTO(CommodityFormDTO commodityFormDTO) {
//        // Convert CommodityFormDTO to CommodityForm entity
//        CommodityForm commodityForm = new CommodityForm();
//        commodityForm.setId(commodityFormDTO.getId());
//        commodityForm.setCommodityFormName(commodityFormDTO.getCommodityFormName());
//        return commodityForm;
//    }
//
//    private CommodityGroups commodityGroupFromDTO(CommodityGroupDTO commodityGroupDTO) {
//        // Convert CommodityGroupDTO to CommodityGroup entity
//        CommodityGroups commodityGroup = new CommodityGroups();
//        commodityGroup.setId(commodityGroupDTO.getId());
//        commodityGroup.setGroupName(commodityGroupDTO.getGroupName());
//        return commodityGroup;
//    }

//    private Color colorFromDTO(ColorDTO colorDTO) {
//        // Convert ColorDTO to Color entity
//        Color color = new Color();
//        color.setId(colorDTO.getId());
//        color.setColorName(colorDTO.getColorName());
//        return color;
//    }
//
//    // Fetch major commodities where isUnderMajorCommodity = false
//    public List<CommodityMaster> getMajorCommoditiesOnly() {
//        return commodityMasterRepository.findByIsUnderMajorCommodityFalse();
//    }
    
  
    
    public List<CommodityMaster> getAllCommodityMasters() {
        List<CommodityMaster> master = commodityMasterRepository.findAll();
        return master;
    }

    public CommodityMaster getCommodityMasterById(Long id) {
        return commodityMasterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CommodityMaster not found with id " + id));
    }
    public Optional<CommodityGroups> getCommodityGroupById(Long groupId) {
        return commodityGroupsRepository.findById(groupId);
    }
    public List<CommodityGroups> getAllCommodityGroups() {
        return commodityGroupsRepository.findAll();
    }


    public void deleteCommodityMaster(Long id) {
        CommodityMaster commodityMaster = getCommodityMasterById(id);
        commodityMasterRepository.delete(commodityMaster);
    }
//    public 	CommodityMaster createCommodity(CommodityMaster master) {
//        return commodityMasterRepository.save(master);
//    }
    
    
  //Find by Id
//    public CommodityMaster findById(Integer id) {
//        return commodityMasterRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("CommodityMaster not found with id " + id));
//    }
    
    
    public CommodityMaster createCommodity(CommodityMasterFullDTO commodityDTO) {
        // Fetch the commodity group
        CommodityGroups commodityGroup = commodityGroupsRepository.findById(commodityDTO.getId()) // Use the appropriate ID field
                .orElseThrow(() -> new RuntimeException("Commodity group not found"));

        // Create new Commodity entity
        CommodityMaster commodity = new CommodityMaster();
        commodity.setCommodityGroup(commodityGroup);
        commodity.setIsUnderMajorCommodity(commodityDTO.getIsUnderMajorCommodity());
        commodity.setCommodityName(commodityDTO.getCommodityName()); // Map additional fields as needed
        commodity.setCommodityLocalName(commodityDTO.getCommodityLocalName());
        commodity.setCommodityShortName(commodityDTO.getCommodityShortName());
        commodity.setRemarks(commodityDTO.getRemarks());
        commodity.setStatus(commodityDTO.getStatus());
        commodity.setFeedBy(commodityDTO.getFeedBy());
        commodity.setFeedDate(commodityDTO.getFeedDate());
        commodity.setDocument(commodityDTO.getDocument());
        
        // Logic for generating the commodity code
        String groupCode = commodityGroup.getGroupCode();
        if (groupCode == null || groupCode.isEmpty()) {
            throw new IllegalArgumentException("Group code cannot be null or empty");
        }

        Long majorCommodityCount = commodityMasterRepository.countByCommodityGroupAndIsUnderMajorCommodityFalse(commodityGroup);

        if (!commodityDTO.getIsUnderMajorCommodity()) {
            majorCommodityCount++;
        }

        Long subCommodityCount = 0L;
        if (commodityDTO.getIsUnderMajorCommodity()) {
            CommodityMaster majorCommodity = commodityMasterRepository.findById(commodityDTO.getMajorCommodityId())
                    .orElseThrow(() -> new RuntimeException("Major commodity not found"));
            commodity.setMajorCommodity(majorCommodity);

            subCommodityCount = commodityMasterRepository.countByCommodityGroupAndIsUnderMajorCommodityTrueAndMajorCommodity(commodityGroup, majorCommodity);
            subCommodityCount++;  // Increment for the new minor commodity
        }

        // Generate commodity code
        String majorCommodityCode = String.format("%02d", majorCommodityCount);
        String subCommodityCode = subCommodityCount > 0 ? String.format("%02d", subCommodityCount) : "00";
        String commodityCode = groupCode + majorCommodityCode + subCommodityCode;

        commodity.setCommodityCode(commodityCode);

        // Save the commodity to the database
        return commodityMasterRepository.save(commodity);
    }
    
//    public List<CommodityMaster> getCommodities(CommodityGroups commodityGroup, boolean isMajor) {
//        return commodityMasterRepository.findByCommodityGroupAndIsMajor(commodityGroup.getId(), isMajor);
//    }
//    
//    public List<CommodityMaster> getMajorCommodities() {
//        return commodityMasterRepository.findByIsUnderMajorCommodityFalse();
//    }

    // Save CommodityMaster logic
  //

    // Update CommodityMaster logic
//    public CommodityMaster updateCommodityMaster(Integer id, CommodityMaster commodityMasterDetails) {
//        CommodityMaster commodityMaster = findById(id);
//        
//        // Update fields
//        commodityMaster.setCommodityName(commodityMasterDetails.getCommodityName());
//        // Update other fields...
//
//        return commodityMasterRepository.save(commodityMaster);
//    }

    public List<CommodityMasterFullDTO> getAllCommoditiesOnly() {
        List<CommodityMaster> masters = commodityMasterRepository.findAll();
        return masters.stream()
            .map(master -> new CommodityMasterFullDTO(
                master.getId(),
                master.getCommodityCode(),
                master.getCommodityName(),
                master.getCommodityLocalName(),
                master.getCommodityShortName(),
                master.getRemarks(),
                master.getStatus(),
                master.getFeedBy(),
                master.getFeedDate(),
                master.getDocument(),
                master.getMajorCommodity() != null ? master.getMajorCommodity().getId() : null, // Assuming this returns a Long
                master.getIsUnderMajorCommodity(),
                master.getModule() != null ? new ModuleMasterDTO(master.getModule().getModuleId(), master.getModule().getModuleName()) : null,
                master.getMeasurementUnit() != null ? new MeasurementUnitDTO(master.getMeasurementUnit().getId(), master.getMeasurementUnit().getMeasurementUnitName()) : null,
                master.getCropSeason() != null ? new CropSeasonDTO(master.getCropSeason().getId(), master.getCropSeason().getCropSeasonName()) : null,
                master.getCommodityForm() != null ? new CommodityFormDTO(master.getCommodityForm().getId(), master.getCommodityForm().getCommodityFormName()) : null,
                master.getCommodityGroup() != null ? new CommodityGroupDTO(master.getCommodityGroup().getId(), master.getCommodityGroup().getGroupName()) : null,
                master.getColor() != null ? new ColorDTO(master.getColor().getId(), master.getColor().getColorName()) : null
            ))
            .collect(Collectors.toList());
    }

}