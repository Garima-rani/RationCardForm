package com.example.model;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.*;

@Entity
@Table(name = "commodity_master")
public class CommodityMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    @Column(name="commoditycode")
    private String commodityCode;

    @Column(name = "commodity_name", nullable = false, length = 255)
    private String commodityName;

    @Column(name = "commodity_local_name", length = 255)
    private String commodityLocalName;

    @Column(name = "commodity_short_name", length = 50)
    private String commodityShortName;

    @Column(name = "remarks", length = 500)
    private String remarks;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "feed_by", length = 100)
    private String feedBy;

    @Column(name = "feed_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate feedDate;

    @Column(name = "document")
    private byte[] document;
    
    @Column(name="is_under_major_commodity")
    private boolean isUnderMajorCommodity; 
    @ManyToOne
    @JoinColumn(name = "major_commodity_id", nullable = true) // Nullable because it's only set if it's a sub-commodity
    private CommodityMaster majorCommodity;
   

    @ManyToOne
    @JoinColumn(name = "commodity_form_id")
    private CommodityForm commodityForm;

    @ManyToOne
    @JoinColumn(name = "crop_season_id")
    private CropSeasonMaster cropSeason;

    @ManyToOne
    @JoinColumn(name = "color_id" , nullable = true)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private ModuleMaster module;
    
    @ManyToOne
    @JoinColumn(name = "commodity_group_id")
    private CommodityGroups commodityGroup;

    @ManyToOne
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnit measurementUnit;
    
   
    // Getters and Setters
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
    

    
	public CommodityMaster getMajorCommodity() {
		return majorCommodity;
	}

	public void setMajorCommodity(CommodityMaster majorCommodity) {
		this.majorCommodity = majorCommodity;
	}

	public void setUnderMajorCommodity(boolean isUnderMajorCommodity) {
		this.isUnderMajorCommodity = isUnderMajorCommodity;
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
    

    public Boolean getIsUnderMajorCommodity() {
		return isUnderMajorCommodity;
	}

	public void setIsUnderMajorCommodity(Boolean isUnderMajorCommodity) {
		this.isUnderMajorCommodity = isUnderMajorCommodity;
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

    public CommodityForm getCommodityForm() {
        return commodityForm;
    }

    public void setCommodityForm(CommodityForm commodityForm) {
        this.commodityForm = commodityForm;
    }

    public CropSeasonMaster getCropSeason() {
        return cropSeason;
    }

    public void setCropSeason(CropSeasonMaster cropSeason) {
        this.cropSeason = cropSeason;
    }


	public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ModuleMaster getModule() {
        return module;
    }

    public void setModule(ModuleMaster module) {
        this.module = module;
    }

    public CommodityGroups getCommodityGroup() {
        return commodityGroup;
    }

    public void setCommodityGroup(CommodityGroups commodityGroup) {
        this.commodityGroup = commodityGroup;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }
	

	

	public CommodityMaster(Long id, String commodityCode, String commodityName, String commodityLocalName,
			String commodityShortName, String remarks, String status, String feedBy, LocalDate feedDate,
			byte[] document, boolean isUnderMajorCommodity, CommodityMaster majorCommodity, CommodityForm commodityForm,
			CropSeasonMaster cropSeason, Color color, ModuleMaster module, CommodityGroups commodityGroup,
			MeasurementUnit measurementUnit) {
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
		this.isUnderMajorCommodity = isUnderMajorCommodity;
		this.majorCommodity = majorCommodity;
		this.commodityForm = commodityForm;
		this.cropSeason = cropSeason;
		this.color = color;
		this.module = module;
		this.commodityGroup = commodityGroup;
		this.measurementUnit = measurementUnit;
	}

	public CommodityMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CommodityMaster [id=" + id + ", commodityCode=" + commodityCode + ", commodityName=" + commodityName
				+ ", commodityLocalName=" + commodityLocalName + ", commodityShortName=" + commodityShortName
				+ ", remarks=" + remarks + ", status=" + status + ", feedBy=" + feedBy + ", feedDate=" + feedDate
				+ ", isUnderMajorCommodity=" + isUnderMajorCommodity + ", majorCommodity=" + majorCommodity
				+ ", commodityForm=" + commodityForm + ", cropSeason=" + cropSeason + ", color=" + color + ", module="
				+ module + ", commodityGroup=" + commodityGroup + ", measurementUnit=" + measurementUnit + "]";
	}

	

	
	

	

    
}
