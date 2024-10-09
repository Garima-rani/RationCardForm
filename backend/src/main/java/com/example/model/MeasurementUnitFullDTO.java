package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MeasurementUnitFullDTO {
	private Long id;
    private String measurementUnitName;
    private String measurementUnitShortName;
    private String measurementUnitLocalName;
    private int decimalPrecision;
    private String remarks;   
    private String status;  
    private String feedBy;
    private LocalDateTime feedDate;
    
	
	private CommodityFormDTO commodityForm;
	private StateDto state;
	private LanguageDTO language;
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
	public String getMeasurementUnitShortName() {
		return measurementUnitShortName;
	}
	public void setMeasurementUnitShortName(String measurementUnitShortName) {
		this.measurementUnitShortName = measurementUnitShortName;
	}
	public String getMeasurementUnitLocalName() {
		return measurementUnitLocalName;
	}
	public void setMeasurementUnitLocalName(String measurementUnitLocalName) {
		this.measurementUnitLocalName = measurementUnitLocalName;
	}
	public int getDecimalPrecision() {
		return decimalPrecision;
	}
	public void setDecimalPrecision(int decimalPrecision) {
		this.decimalPrecision = decimalPrecision;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFeedBy() {
		return feedBy;
	}
	public void setFeedBy(String feedBy) {
		this.feedBy = feedBy;
	}
	public LocalDateTime getFeedDate() {
		return feedDate;
	}
	public void setFeedDate(LocalDateTime feedDate) {
		this.feedDate = feedDate;
	}
	public CommodityFormDTO getCommodityForm() {
		return commodityForm;
	}
	public void setCommodityForm(CommodityFormDTO commodityForm) {
		this.commodityForm = commodityForm;
	}
	public StateDto getState() {
		return state;
	}
	public void setState(StateDto state) {
		this.state = state;
	}
	public LanguageDTO getLanguage() {
		return language;
	}
	public void setLanguage(LanguageDTO language) {
		this.language = language;
	}
	public MeasurementUnitFullDTO(Long id, String measurementUnitName, String measurementUnitShortName,
			String measurementUnitLocalName, int decimalPrecision, String remarks, String status, String feedBy,
			LocalDateTime feedDate, CommodityFormDTO commodityForm, StateDto state, LanguageDTO language) {
		super();
		this.id = id;
		this.measurementUnitName = measurementUnitName;
		this.measurementUnitShortName = measurementUnitShortName;
		this.measurementUnitLocalName = measurementUnitLocalName;
		this.decimalPrecision = decimalPrecision;
		this.remarks = remarks;
		this.status = status;
		this.feedBy = feedBy;
		this.feedDate = feedDate;
		this.commodityForm = commodityForm;
		this.state = state;
		this.language = language;
	}
	
	
	
	
    
}
