package com.example.model;

import java.time.LocalDate;
public class CommodityMasterFullDTO {	
	private Long id;
    private String commodityCode;
    private String commodityName;
    private String commodityLocalName;
    private String commodityShortName;
    private String remarks;
    private String status;
    private String feedBy;
    private LocalDate feedDate;
    private byte[] document;
    private Long majorCommodityId;
    private Boolean isUnderMajorCommodity; 
    private ModuleMasterDTO moduleMaster;
    private MeasurementUnitDTO measurementUnit;
    private CropSeasonDTO cropSeason;
    private CommodityFormDTO commodityForm;
    private CommodityGroupDTO commodityGroup;
    private ColorDTO color;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCommodityCode() {
		return commodityCode;
	}
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getCommodityLocalName() {
		return commodityLocalName;
	}
	public void setCommodityLocalName(String commodityLocalName) {
		this.commodityLocalName = commodityLocalName;
	}
	public String getCommodityShortName() {
		return commodityShortName;
	}
	public void setCommodityShortName(String commodityShortName) {
		this.commodityShortName = commodityShortName;
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
	public LocalDate getFeedDate() {
		return feedDate;
	}
	public void setFeedDate(LocalDate feedDate) {
		this.feedDate = feedDate;
	}
	public byte[] getDocument() {
		return document;
	}
	public void setDocument(byte[] document) {
		this.document = document;
	}
	public ModuleMasterDTO getModuleMaster() {
		return moduleMaster;
	}
	public void setModuleMaster(ModuleMasterDTO moduleMaster) {
		this.moduleMaster = moduleMaster;
	}
	public MeasurementUnitDTO getMeasurementUnit() {
		return measurementUnit;
	}
	public void setMeasurementUnit(MeasurementUnitDTO measurementUnit) {
		this.measurementUnit = measurementUnit;
	}
	public CropSeasonDTO getCropSeason() {
		return cropSeason;
	}
	public void setCropSeason(CropSeasonDTO cropSeason) {
		this.cropSeason = cropSeason;
	}
	public CommodityFormDTO getCommodityForm() {
		return commodityForm;
	}
	public void setCommodityForm(CommodityFormDTO commodityForm) {
		this.commodityForm = commodityForm;
	}
	public CommodityGroupDTO getCommodityGroup() {
		return commodityGroup;
	}
	public void setCommodityGroup(CommodityGroupDTO commodityGroup) {
		this.commodityGroup = commodityGroup;
	}
	public ColorDTO getColor() {
		return color;
	}
	public void setColor(ColorDTO color) {
		this.color = color;
	}
	
	public Long getMajorCommodityId() {
		return majorCommodityId;
	}
	public void setMajorCommodityId(Long majorCommodityId) {
		this.majorCommodityId = majorCommodityId;
	}
	
	 public Boolean getIsUnderMajorCommodity() {
			return isUnderMajorCommodity;
		}

		public void setIsUnderMajorCommodity(Boolean isUnderMajorCommodity) {
			this.isUnderMajorCommodity = isUnderMajorCommodity;
		}
	public CommodityMasterFullDTO(Long id, String commodityCode, String commodityName, String commodityLocalName,
			String commodityShortName, String remarks, String status, String feedBy, LocalDate feedDate,
			byte[] document, Long majorCommodityId, boolean isUnderMajorCommodity, ModuleMasterDTO moduleMaster,
			MeasurementUnitDTO measurementUnit, CropSeasonDTO cropSeason, CommodityFormDTO commodityForm,
			CommodityGroupDTO commodityGroup, ColorDTO color) {
		super();
		this.id = id;
		this.commodityCode = commodityCode;
		this.commodityName = commodityName;
		this.commodityLocalName = commodityLocalName;
		this.commodityShortName = commodityShortName;
		this.remarks = remarks;
		this.status = status;
		this.feedBy = feedBy;
		this.feedDate = feedDate;
		this.document = document;
		this.majorCommodityId = majorCommodityId;
		this.isUnderMajorCommodity = isUnderMajorCommodity;
		this.moduleMaster = moduleMaster;
		this.measurementUnit = measurementUnit;
		this.cropSeason = cropSeason;
		this.commodityForm = commodityForm;
		this.commodityGroup = commodityGroup;
		this.color = color;
	}
	
}
