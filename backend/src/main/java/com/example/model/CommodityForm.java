package com.example.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "commodity_form")
public class CommodityForm {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    @Column(name = "commodity_form_code", nullable = false)
    private Long commodityFormCode;
    
    @Column(name = "commodity_form_name", nullable = false)
    private String commodityFormName;
    
    @Column(name = "commodity_form_local_name", nullable = false)
    private String commodityFormLocalName;
    
    @Column(name = "commodity_form_short_name", nullable = false)
    private String commodityFormShortName;
    
    @Column(name = "feed_by", nullable = false)
    private String feedBy;

    @Column(name = "feed_date", nullable = false)
    private LocalDate feedDate;

    @Column(name = "remarks", nullable = false)
    private String remarks;
    
    @Column(name = "status", nullable = false)
    private String status;

	public Long getCommodityFormCode() {
		return commodityFormCode;
	}

	public void setCommodityFormCode(Long commodityFormCode) {
		this.commodityFormCode = commodityFormCode;
	}

	public String getCommodityFormName() {
		return commodityFormName;
	}

	public void setCommodityFormName(String commodityFormName) {
		this.commodityFormName = commodityFormName;
	}

	public String getCommodityFormLocalName() {
		return commodityFormLocalName;
	}

	public void setCommodityFormLocalName(String commodityFormLocalName) {
		this.commodityFormLocalName = commodityFormLocalName;
	}

	public String getCommodityFormShortName() {
		return commodityFormShortName;
	}

	public void setCommodityFormShortName(String commodityFormShortName) {
		this.commodityFormShortName = commodityFormShortName;
	}

	public String getFeedBy() {
		return feedBy;
	}

	public void setFeedBy(String feedBy) {
		this.feedBy = feedBy;
	}

	public LocalDate getFeedDate() {
		return feedDate;
	}

	public void setFeedDate(LocalDate feedDate) {
		this.feedDate = feedDate;
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
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CommodityForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public CommodityForm(Long id, Long commodityFormCode, String commodityFormName, String commodityFormLocalName,
			String commodityFormShortName, String feedBy, LocalDate feedDate, String remarks, String status) {
		super();
		this.id = id;
		this.commodityFormCode = commodityFormCode;
		this.commodityFormName = commodityFormName;
		this.commodityFormLocalName = commodityFormLocalName;
		this.commodityFormShortName = commodityFormShortName;
		this.feedBy = feedBy;
		this.feedDate = feedDate;
		this.remarks = remarks;
		this.status = status;
	}

	@Override
	public String toString() {
		return "CommodityForm [id=" + id + ", commodityFormCode=" + commodityFormCode + ", commodityFormName="
				+ commodityFormName + ", commodityFormLocalName=" + commodityFormLocalName + ", commodityFormShortName="
				+ commodityFormShortName + ", feedBy=" + feedBy + ", feedDate=" + feedDate + ", remarks=" + remarks
				+ ", status=" + status + "]";
	}

	
    
}