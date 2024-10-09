package com.example.controller;

import java.util.Arrays;
import java.util.List;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.StatItem;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

	@GetMapping
	public List<StatItem> getStats() {
	    return Arrays.asList(
	        new StatItem("Fair Price Shop", "5,38,098", "/icons/fair-price-shop.png"),
	        new StatItem("POS enabled Fair Price Shop", "4,88,832", "/icons/pos-enabled.png"),
	        new StatItem("Ration Cards", "19.13 Crore", "/icons/ration-cards.png"),
	        new StatItem("Beneficiaries", "76.69 Crore", "/icons/beneficiaries.png"),
	        new StatItem("Central Allocation", "42.99 LMT", "/icons/central-allocation.png"),
	        new StatItem("State Allocation", "22.03 LMT", "/icons/state-allocation.png"),
	        new StatItem("Total Distribution", "19.42 LMT", "/icons/total-distribution.png")
	    );
	}

}
