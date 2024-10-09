package com.example.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "module_master")
public class ModuleMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private Long moduleId;

    @Column(name = "module_name", nullable = false, length = 255)
    private String moduleName;

    @Column(name = "feed_by", nullable = false, length = 100)
    private String feedBy;

    @Column(name = "feed_date", nullable = false)
    private LocalDateTime feedDate = LocalDateTime.now();

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    // Constructors, Getters and Setters

    public ModuleMaster() {}

    public ModuleMaster(String moduleName, String feedBy, String status, String remarks) {
        this.moduleName = moduleName;
        this.feedBy = feedBy;
        this.status = status;
        this.remarks = remarks;
        this.feedDate = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

	public ModuleMaster(Long moduleId, String moduleName, String feedBy, LocalDateTime feedDate, String status,
			String remarks) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.feedBy = feedBy;
		this.feedDate = feedDate;
		this.status = status;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ModuleMaster [moduleId=" + moduleId + ", moduleName=" + moduleName + ", feedBy=" + feedBy
				+ ", feedDate=" + feedDate + ", status=" + status + ", remarks=" + remarks + "]";
	}
    
}
