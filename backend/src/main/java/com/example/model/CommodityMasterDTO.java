package com.example.model;

import java.time.LocalDate;
import java.util.Arrays;


public class CommodityMasterDTO {

    // Commodity Master Fields
    private Integer Id; 
    private String commodityName;
    private String commodityLocalName;
    private String commodityShortName;
    private String remarks;
    private String status;
    private String feedBy;
    private LocalDate feedDate;
    private byte[] document;

    // Foreign Key 
    private Integer commodityFormId;
    private String commodityFormName;
    private Integer cropSeasonId;
    private String cropSeasonName;
    private Integer colorId;
    private String colorName;
    private Integer moduleId;
    private String moduleName;
    private Integer commodityGroupId;
    private String groupName;
    private Integer measurementUnitId;
    private String measurementUnitName;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	public Integer getCommodityFormId() {
		return commodityFormId;
	}
	public void setCommodityFormId(Integer commodityFormId) {
		this.commodityFormId = commodityFormId;
	}
	public String getCommodityFormName() {
		return commodityFormName;
	}
	public void setCommodityFormName(String commodityFormName) {
		this.commodityFormName = commodityFormName;
	}
	public Integer getCropSeasonId() {
		return cropSeasonId;
	}
	public void setCropSeasonId(Integer cropSeasonId) {
		this.cropSeasonId = cropSeasonId;
	}
	public String getCropSeasonName() {
		return cropSeasonName;
	}
	public void setCropSeasonName(String cropSeasonName) {
		this.cropSeasonName = cropSeasonName;
	}
	public Integer getColorId() {
		return colorId;
	}
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public Integer getCommodityGroupId() {
		return commodityGroupId;
	}
	public void setCommodityGroupId(Integer commodityGroupId) {
		this.commodityGroupId = commodityGroupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Integer getMeasurementUnitId() {
		return measurementUnitId;
	}
	public void setMeasurementUnitId(Integer measurementUnitId) {
		this.measurementUnitId = measurementUnitId;
	}
	public String getMeasurementUnitName() {
		return measurementUnitName;
	}
	public void setMeasurementUnitName(String measurementUnitName) {
		this.measurementUnitName = measurementUnitName;
	}
	public CommodityMasterDTO(Integer id, String commodityName, String commodityLocalName, String commodityShortName,
			String remarks, String status, String feedBy, LocalDate feedDate, byte[] document, Integer commodityFormId,
			String commodityFormName, Integer cropSeasonId, String cropSeasonName, Integer colorId, String colorName,
			Integer moduleId, String moduleName, Integer commodityGroupId, String groupName, Integer measurementUnitId,
			String measurementUnitName) {
		super();
		Id = id;
		this.commodityName = commodityName;
		this.commodityLocalName = commodityLocalName;
		this.commodityShortName = commodityShortName;
		this.remarks = remarks;
		this.status = status;
		this.feedBy = feedBy;
		this.feedDate = feedDate;
		this.document = document;
		this.commodityFormId = commodityFormId;
		this.commodityFormName = commodityFormName;
		this.cropSeasonId = cropSeasonId;
		this.cropSeasonName = cropSeasonName;
		this.colorId = colorId;
		this.colorName = colorName;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.commodityGroupId = commodityGroupId;
		this.groupName = groupName;
		this.measurementUnitId = measurementUnitId;
		this.measurementUnitName = measurementUnitName;
	}
	@Override
	public String toString() {
		return "CommodityMasterDTO [Id=" + Id + ", commodityName=" + commodityName + ", commodityLocalName="
				+ commodityLocalName + ", commodityShortName=" + commodityShortName + ", remarks=" + remarks
				+ ", status=" + status + ", feedBy=" + feedBy + ", feedDate=" + feedDate + ", document="
				+ Arrays.toString(document) + ", commodityFormId=" + commodityFormId + ", commodityFormName="
				+ commodityFormName + ", cropSeasonId=" + cropSeasonId + ", cropSeasonName=" + cropSeasonName
				+ ", colorId=" + colorId + ", colorName=" + colorName + ", moduleId=" + moduleId + ", moduleName="
				+ moduleName + ", commodityGroupId=" + commodityGroupId + ", groupName=" + groupName
				+ ", measurementUnitId=" + measurementUnitId + ", measurementUnitName=" + measurementUnitName + "]";
	}

   

    
}
