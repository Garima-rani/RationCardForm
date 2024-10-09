package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.CommodityForm;
import com.example.model.CommodityFormDTO;
import com.example.service.CommodityFormService;

import java.util.List;

@RestController
@RequestMapping("/api/commodity-forms")
public class CommodityFormController {

    @Autowired
    private CommodityFormService service;

    @GetMapping
    public List<CommodityForm> getAll() {
        return service.getAllCommodityForms();
    }

    @PostMapping
    public CommodityForm create(@RequestBody CommodityForm commodityForm) {
        return service.createCommodityForm(commodityForm);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommodityForm> getById(@PathVariable Long id) {
        CommodityForm commodityForm = service.getCommodityFormById(id);
        return ResponseEntity.ok(commodityForm);
    }

    @PutMapping("/{id}")
    public CommodityForm update(@PathVariable Long id, @RequestBody CommodityForm commodityForm) {
        return service.updateCommodityForm(id, commodityForm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCommodityForm(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/names")
    public List<CommodityFormDTO> getAllCommodityFormNames() {
        return service.getAllCommodityNames();
    }
}

