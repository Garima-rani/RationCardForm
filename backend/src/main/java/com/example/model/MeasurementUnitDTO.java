package com.example.model;



public class MeasurementUnitDTO {
    private Long id;
    private String measurementUnitName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMeasurementUnitName() {
		return measurementUnitName;
	}
	public void setMeasurementUnitName(String measurementUnitName) {
		this.measurementUnitName = measurementUnitName;
	}
	public MeasurementUnitDTO(Long id, String measurementUnitName) {
		super();
		this.id = id;
		this.measurementUnitName = measurementUnitName;
	}
    
    // Constructors, Getters, and Setters
}

