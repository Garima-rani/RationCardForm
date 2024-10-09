package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class PhysicalDetails {
    private Boolean orthoAbled;
    private Boolean visuallyAbled;
    private Boolean hearingImpaired;
    private Boolean multipleAbled;
    private String percentage; 
    private String dueTo; 
    private String since; 
    private int year; 
    
    @Column(name = "physical_certificate")
    private String certificate; // Renamed field

    public Boolean getOrthoAbled() {
        return orthoAbled;
    }

    public void setOrthoAbled(Boolean orthoAbled) {
        this.orthoAbled = orthoAbled;
    }

    public Boolean getVisuallyAbled() {
        return visuallyAbled;
    }

    public void setVisuallyAbled(Boolean visuallyAbled) {
        this.visuallyAbled = visuallyAbled;
    }

    public Boolean getHearingImpaired() {
        return hearingImpaired;
    }

    public void setHearingImpaired(Boolean hearingImpaired) {
        this.hearingImpaired = hearingImpaired;
    }

    public Boolean getMultipleAbled() {
        return multipleAbled;
    }

    public void setMultipleAbled(Boolean multipleAbled) {
        this.multipleAbled = multipleAbled;
    }

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getDueTo() {
		return dueTo;
	}

	public void setDueTo(String dueTo) {
		this.dueTo = dueTo;
	}

	public String getSince() {
		return since;
	}

	public void setSince(String since) {
		this.since = since;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

    

    
}
