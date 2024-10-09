package com.example.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Occupation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String nameLocal;
    private String shortName;
    private Date date;
    private String feedBy;
    private String status;
    

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFeedBy() {
		return feedBy;
	}

	public void setFeedBy(String feedBy) {
		this.feedBy = feedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Occupation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Occupation(Long id, String name, String nameLocal, String shortName, Date date, String feedBy,
			boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.nameLocal = nameLocal;
		this.shortName = shortName;
		this.date = date;
		this.feedBy = feedBy;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Occupation [id=" + id + ", name=" + name + ", nameLocal=" + nameLocal + ", shortName=" + shortName
				+ ", date=" + date + ", feedBy=" + feedBy + ", status=" + status + "]";
	}

	

}
