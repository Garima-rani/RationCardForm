package com.example.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nationality {
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
	public Nationality() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nationality(Long id, String name, String nameLocal, String shortName, Date date, String feedBy,
			String status) {
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
		return "Nationality [id=" + id + ", name=" + name + ", nameLocal=" + nameLocal + ", shortName=" + shortName
				+ ", date=" + date + ", feedBy=" + feedBy + ", status=" + status + "]";
	}

	

	


}
