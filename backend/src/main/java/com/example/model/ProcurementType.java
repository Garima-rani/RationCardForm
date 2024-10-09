package com.example.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProcurementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="remarks")
    private String remarks;
    
    @Column(name="status")
    private String status;
    
    @Column(name="feedby")
    private String feedBy;
    
    @Column(name="feeddate")
    private LocalDate feedDate;

    // Default constructor
    public ProcurementType() {}

    // Constructor with parameters
   

    // String-based constructor for deserialization
    @JsonCreator
    public ProcurementType(String name) {
        this.name = name;
    }

    public ProcurementType(Long id, String name, String remarks, String status, String feedBy, LocalDate feedDate) {
		super();
		this.id = id;
		this.name = name;
		this.remarks = remarks;
		this.status = status;
		this.feedBy = feedBy;
		this.feedDate = feedDate;
	}

	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

	@Override
	public String toString() {
		return "ProcurementType [id=" + id + ", name=" + name + ", remarks=" + remarks + ", status=" + status
				+ ", feedBy=" + feedBy + ", feedDate=" + feedDate + "]";
	}

	
}
