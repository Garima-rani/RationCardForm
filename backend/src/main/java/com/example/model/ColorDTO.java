package com.example.model;

public class ColorDTO {
	
	private Long id;
	private String colorName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public ColorDTO(Long id, String colorName) {
		super();
		this.id = id;
		this.colorName = colorName;
	}
	

}
