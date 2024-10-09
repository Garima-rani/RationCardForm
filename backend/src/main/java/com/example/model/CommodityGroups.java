package com.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "commodity_group")
public class CommodityGroups {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "group_code", nullable = false)
    private String groupCode;
    
    @Column(name = "group_name", nullable = false)
    private String groupName;
    
    @Column(name = "namelocal", nullable = false)
    private String nameLocal;
    
    @Column(name = "short_name", nullable = false)
    private String shortName;
    
    @Column(name = "feed_by", nullable = false)
    private String feedBy;  // Will be automatically filled with username

    @Column(name = "feed_date", nullable = false)
    private LocalDate feedDate;  // Will be automatically filled with current date
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "remarks")
    private String remarks;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
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

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getNameLocal() {
		return nameLocal;
	}

	public void setNameLocal(String nameLocal) {
		this.nameLocal = nameLocal;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	public void setFeedDate(LocalDate localDate) {
		this.feedDate = localDate;
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

	public CommodityGroups() {}

   

	public CommodityGroups(Long id, String groupCode, String groupName, String nameLocal, String shortName,
			String feedBy, LocalDate feedDate, String status, String remarks, States state, Language language) {
		super();
		this.id = id;
		this.groupCode = groupCode;
		this.groupName = groupName;
		this.nameLocal = nameLocal;
		this.shortName = shortName;
		this.feedBy = feedBy;
		this.feedDate = feedDate;
		this.status = status;
		this.remarks = remarks;
		this.state = state;
		this.language = language;
	}
	public CommodityGroups(Long id, String groupCode, String groupName, String nameLocal, String shortName,
            String feedBy, LocalDate feedDate, String status, String remarks) {
this.id = id;
this.groupCode = groupCode;
this.groupName = groupName;
this.nameLocal = nameLocal;
this.shortName = shortName;
this.feedBy = feedBy;
this.feedDate = feedDate;
this.status = status;
this.remarks = remarks;
}

	@Override
	public String toString() {
		return "CommodityGroups [id=" + id + ", groupCode=" + groupCode + ", groupName=" + groupName + ", nameLocal="
				+ nameLocal + ", shortName=" + shortName + ", feedBy=" + feedBy + ", feedDate=" + feedDate + ", status="
				+ status + ", remarks=" + remarks + ", state=" + state + ", language=" + language + "]";
	}

}
