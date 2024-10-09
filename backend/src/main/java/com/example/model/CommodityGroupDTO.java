package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Column;

public class CommodityGroupDTO {
	private Long id;
	private String groupName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public CommodityGroupDTO(Long id, String groupName) {
		super();
		this.id = id;
		this.groupName = groupName;
	}
    
	
	
	
	

}
