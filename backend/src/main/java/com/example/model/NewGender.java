package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class NewGender {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String gender;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public NewGender() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewGender(Long id, String gender) {
		super();
		this.id = id;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "NewGender [id=" + id + ", gender=" + gender + "]";
	}

	

}
