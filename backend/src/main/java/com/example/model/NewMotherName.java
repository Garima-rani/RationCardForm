package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class NewMotherName {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String mother_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public NewMotherName() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewMotherName(Long id, String mother_name) {
		super();
		this.id = id;
		this.mother_name = mother_name;
	}

	@Override
	public String toString() {
		return "NewMotherName [id=" + id + ", mother_name=" + mother_name + "]";
	}

	
	
}
