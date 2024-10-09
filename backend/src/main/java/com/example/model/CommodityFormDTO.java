package com.example.model;

public class CommodityFormDTO {
	private Long id;
	private String commodityFormName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommodityFormName() {
		return commodityFormName;
	}
	public void setCommodityFormName(String commodityFormName) {
		this.commodityFormName = commodityFormName;
	}
	public CommodityFormDTO(Long id, String commodityFormName) {
		super();
		this.id = id;
		this.commodityFormName = commodityFormName;
	}
	
	
	
	

}
