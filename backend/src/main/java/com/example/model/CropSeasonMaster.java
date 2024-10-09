package com.example.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crop_season_master")
public class CropSeasonMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "crop_season_code", nullable = false, unique = true, length = 50)
    private String cropSeasonCode;

    @Column(name = "crop_season_name", nullable = false, length = 255)
    private String cropSeasonName;

    @Column(name = "crop_season_short_name", length = 100)
    private String cropSeasonShortName;

    @Column(name = "crop_season_local_name", length = 255)
    private String cropSeasonLocalName;

    @Column(name = "major_crop_season", length = 100)
    private String majorCropSeason;

    @Column(name = "feed_by", length = 100)
    private String feedBy;

    @Column(name = "feed_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime feedDate;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "status", length = 50)
    private String status;

    // Getters and Setters
    
    public String getCropSeasonCode() { return cropSeasonCode; }
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCropSeasonCode(String cropSeasonCode) { this.cropSeasonCode = cropSeasonCode; }

    public String getCropSeasonName() { return cropSeasonName; }
    public void setCropSeasonName(String cropSeasonName) { this.cropSeasonName = cropSeasonName; }

    public String getCropSeasonShortName() { return cropSeasonShortName; }
    public void setCropSeasonShortName(String cropSeasonShortName) { this.cropSeasonShortName = cropSeasonShortName; }

    public String getCropSeasonLocalName() { return cropSeasonLocalName; }
    public void setCropSeasonLocalName(String cropSeasonLocalName) { this.cropSeasonLocalName = cropSeasonLocalName; }

    public String getMajorCropSeason() { return majorCropSeason; }
    public void setMajorCropSeason(String majorCropSeason) { this.majorCropSeason = majorCropSeason; }

    public String getFeedBy() { return feedBy; }
    public void setFeedBy(String feedBy) { this.feedBy = feedBy; }

    public LocalDateTime getFeedDate() { return feedDate; }
    public void setFeedDate(LocalDateTime feedDate) { this.feedDate = feedDate; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
	public CropSeasonMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CropSeasonMaster(String cropSeasonCode, String cropSeasonName, String cropSeasonShortName,
			String cropSeasonLocalName, String majorCropSeason, String feedBy, LocalDateTime feedDate, String remarks,
			String status) {
		super();
		this.cropSeasonCode = cropSeasonCode;
		this.cropSeasonName = cropSeasonName;
		this.cropSeasonShortName = cropSeasonShortName;
		this.cropSeasonLocalName = cropSeasonLocalName;
		this.majorCropSeason = majorCropSeason;
		this.feedBy = feedBy;
		this.feedDate = feedDate;
		this.remarks = remarks;
		this.status = status;
	}
	@Override
	public String toString() {
		return "CropSeasonMaster [cropSeasonCode=" + cropSeasonCode + ", cropSeasonName=" + cropSeasonName
				+ ", cropSeasonShortName=" + cropSeasonShortName + ", cropSeasonLocalName=" + cropSeasonLocalName
				+ ", majorCropSeason=" + majorCropSeason + ", feedBy=" + feedBy + ", feedDate=" + feedDate
				+ ", remarks=" + remarks + ", status=" + status + "]";
	}
    
    
}
