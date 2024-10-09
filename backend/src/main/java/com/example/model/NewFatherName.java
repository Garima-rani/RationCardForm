package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class NewFatherName {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String father_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public NewFatherName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewFatherName(Long id, String father_name) {
		super();
		this.id = id;
		this.father_name = father_name;
	}

	@Override
	public String toString() {
		return "NewFatherName [id=" + id + ", father_name=" + father_name + "]";
	}

	
	

}
