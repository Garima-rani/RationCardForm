package com.example.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "measurement_unit")
public class MeasurementUnit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	    @JoinColumn(name = "commodity_form_id", nullable = false)
	    private CommodityForm commodityForm;// Reference to CommodityForm

    @Column(name = "measurement_unit_name")
    private String measurementUnitName;

    @Column(name = "measurement_unit_short_name")
    private String measurementUnitShortName;

    @Column(name = "measurement_unit_local_name")
    private String measurementUnitLocalName;

    @Column(name = "decimal_precision")
    private int decimalPrecision;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "status")
    private String status;

    @Column(name = "feed_by")
    private String feedBy;

    @Column(name = "feed_date", nullable = false, updatable = false)
    private LocalDateTime feedDate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private States state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
     private Language language;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CommodityForm getCommodityForm() {
		return commodityForm;
	}

	public void setCommodityForm(CommodityForm commodityForm) {
		this.commodityForm = commodityForm;
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
	  
	public States getStates() {
		return state;
	}

	public void setStates(States state) {
		this.state = state;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public MeasurementUnit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeasurementUnit(Long id, CommodityForm commodityForm, String measurementUnitName,
			String measurementUnitShortName, String measurementUnitLocalName, int decimalPrecision, String remarks,
			String status, String feedBy, LocalDateTime feedDate, States state, Language language) {
		super();
		this.id = id;
		this.commodityForm = commodityForm;
		this.measurementUnitName = measurementUnitName;
		this.measurementUnitShortName = measurementUnitShortName;
		this.measurementUnitLocalName = measurementUnitLocalName;
		this.decimalPrecision = decimalPrecision;
		this.remarks = remarks;
		this.status = status;
		this.feedBy = feedBy;
		this.feedDate = feedDate;
		this.state = state;
		this.language = language;
	}

	@Override
	public String toString() {
		return "MeasurementUnit [id=" + id + ", commodityForm=" + commodityForm + ", measurementUnitName="
				+ measurementUnitName + ", measurementUnitShortName=" + measurementUnitShortName
				+ ", measurementUnitLocalName=" + measurementUnitLocalName + ", decimalPrecision=" + decimalPrecision
				+ ", remarks=" + remarks + ", status=" + status + ", feedBy=" + feedBy + ", feedDate=" + feedDate
				+ ", state=" + state + ", language=" + language + "]";
	}
	
}
