package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.CommodityMaster;
import com.example.model.CommodityMasterFullDTO;
import com.example.model.StateFullDto;
import com.example.model.States;
import com.example.service.CommodityMasterService;

import java.util.List;


@RestController
@RequestMapping("/api/commodities")
public class CommodityMasterController {
	@Autowired
    private CommodityMasterService commodityMasterService;

    // Get all commodity masters
    @GetMapping("/all")
    public ResponseEntity<List<CommodityMaster>> getAllCommodityMasters() {
        List<CommodityMaster> commodityMasters = commodityMasterService.getAllCommodityMasters();
        return new ResponseEntity<>(commodityMasters, HttpStatus.OK);
    }

    // Get a commodity master by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<CommodityMaster> getCommodityMasterById(@PathVariable("id") Integer id) {
//        CommodityMaster commodityMaster = commodityMasterService.getCommodityMasterById(id);
//        return new ResponseEntity<>(commodityMaster, HttpStatus.OK);
//    }

//
//    @PostMapping
//    public CommodityMaster createCommodity(@RequestBody CommodityMaster master) {
//        return commodityMasterService.createCommodity(master);
//    }
    // Update an existing commodity master
//    @PutMapping("/update/{id}")
//    public ResponseEntity<CommodityMaster> updateCommodityMaster(@PathVariable("id") Integer id, @RequestBody CommodityMaster commodityMaster) {
//        CommodityMaster updatedCommodityMaster = commodityMasterService.updateCommodityMaster(id, commodityMaster);
//        return new ResponseEntity<>(updatedCommodityMaster, HttpStatus.OK);
//    }

    // Delete a commodity master by ID
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteCommodityMaster(@PathVariable("id") Integer id) {
//        commodityMasterService.deleteCommodityMaster(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
    
    @GetMapping
    public ResponseEntity<List<CommodityMasterFullDTO>> getAllCommoditiesOnly() {
        List<CommodityMasterFullDTO> masters = commodityMasterService.getAllCommoditiesOnly();
        return new ResponseEntity<>(masters, HttpStatus.OK);
    }
    

//    @GetMapping("/major-commodities")
//    public ResponseEntity<List<CommodityMaster>> getMajorCommodities() {
//        List<CommodityMaster> majorCommodities = commodityMasterService.getMajorCommodities();
//        return ResponseEntity.ok(majorCommodities);
//    }

    @PostMapping("/create")
    public ResponseEntity<CommodityMaster> createCommodity(@RequestBody CommodityMasterFullDTO commodityDTO) {
        CommodityMaster createdCommodity = commodityMasterService.createCommodity(commodityDTO);
        return ResponseEntity.ok(createdCommodity);
    }
}
