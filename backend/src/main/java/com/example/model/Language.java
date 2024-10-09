package com.example.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "languages")  // Map to the 'languages' table in your database
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "language_code", nullable = false, unique = true)
    private String languageCode;

    @Column(name = "language_name", nullable = false)
    private String languageName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "remarks", length = 1024)
    private String remarks;

    @Column(name = "script")
    private String script;
    @Column(name = "status")
    private String status;


    @ManyToMany(mappedBy = "languages")
    @JsonIgnore  // Prevent recursion here
    private List<States> states;

    @OneToMany(mappedBy = "language")
    @JsonIgnore
    private List<MeasurementUnit> measurementUnits;
    // Constructors, Getters, and Setters
    public Language() {}


	public Language(Long id, String languageCode, String languageName, String shortName, String remarks, String script,
			String status, List<States> states) {
		super();
		this.id = id;
		this.languageCode = languageCode;
		this.languageName = languageName;
		this.shortName = shortName;
		this.remarks = remarks;
		this.script = script;
		this.status = status;
		this.states = states;
	}






	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

	



	public List<States> getStates() {
		return states;
	}


	public void setStates(List<States> states) {
		this.states = states;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Language [id=" + id + ", languageCode=" + languageCode + ", languageName=" + languageName
				+ ", shortName=" + shortName + ", remarks=" + remarks + ", script=" + script + ", status=" + status
				+ ", states=" + states + "]";
	}
	
    
}

