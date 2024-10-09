package com.example.controller;

import com.example.model.CommodityGroupDTO;
import com.example.model.CommodityGroups;
import com.example.service.CommodityGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commodity-group")
public class CommodityGroupController {

    @Autowired
    private CommodityGroupService commodityGroupService;

    private static final Logger logger = LoggerFactory.getLogger(CommodityGroupController.class);

    // Create a new commodity group (Only for ROLE_ADMIN)
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<CommodityGroups> addCommodityGroup(@RequestBody CommodityGroups commodityGroup) {
        try {
            CommodityGroups savedCommodityGroup = commodityGroupService.save(commodityGroup);
            return new ResponseEntity<>(savedCommodityGroup, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error saving commodity group: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all commodity groups (For ROLE_VIEWER, ROLE_EDITOR, ROLE_ADMIN)
//    @GetMapping
//    @PreAuthorize("hasAnyAuthority('ROLE_VIEWER', 'ROLE_EDITOR', 'ROLE_ADMIN')")
//    public ResponseEntity<List<CommodityGroups>> getAllCommodityGroups() {
//        try {
//            List<CommodityGroups> groups = commodityGroupService.getAllCommodityGroups();
//            return groups.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(groups, HttpStatus.OK);
//        } catch (Exception e) {
//            logger.error("Error retrieving commodity groups: ", e);
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    // Get a commodity group by ID (For ROLE_VIEWER, ROLE_EDITOR, ROLE_ADMIN)
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_VIEWER', 'ROLE_EDITOR', 'ROLE_ADMIN')")
    public ResponseEntity<CommodityGroups> getCommodityGroupById(@PathVariable Long id) {
        Optional<CommodityGroups> group = commodityGroupService.getCommodityGroupById(id);
        return group.map(ResponseEntity::ok)
                .orElseGet(() -> {
                    logger.warn("Commodity Group not found with id: {}", id);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    // Update a commodity group (Only for ROLE_EDITOR)
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_EDITOR')")
    public ResponseEntity<CommodityGroups> updateCommodityGroup(@PathVariable Long id, @RequestBody CommodityGroups updatedGroup) {
        try {
            CommodityGroups updatedCommodityGroup = commodityGroupService.updateCommodityGroup(id, updatedGroup);
            return ResponseEntity.ok(updatedCommodityGroup);
        } catch (RuntimeException e) {
            logger.warn("Error updating commodity group with id: {}. Reason: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error updating commodity group: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a commodity group by ID (Only for ROLE_ADMIN)
    @DeleteMapping("/{id}") 
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteCommodityGroup(@PathVariable Long id) {
        try {
            commodityGroupService.deleteCommodityGroup(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            logger.warn("Error deleting commodity group with id: {}. Reason: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error("Error deleting commodity group: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/names")
    public List<CommodityGroupDTO> getAllCommodityGroupNames() {
        return commodityGroupService.getAllCommodityGroupNames();
    }
    // Get commodity groups without states and languages (For ROLE_VIEWER, ROLE_EDITOR, ROLE_ADMIN)
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_VIEWER', 'ROLE_EDITOR', 'ROLE_ADMIN')")
    public ResponseEntity<List<CommodityGroups>> getBasicCommodityGroups() {
        try {
            List<CommodityGroups> groups = commodityGroupService.getBasicCommodityGroups();
            return groups.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(groups, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error retrieving basic commodity groups: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
