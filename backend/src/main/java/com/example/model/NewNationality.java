package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NewNationality {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String new_nationality;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNew_nationality() {
		return new_nationality;
	}

	public void setNew_nationality(String new_nationality) {
		this.new_nationality = new_nationality;
	}

	public NewNationality() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewNationality(Long id, String new_nationality) {
		super();
		this.id = id;
		this.new_nationality = new_nationality;
	}

	@Override
	public String toString() {
		return "NewNationality [id=" + id + ", new_nationality=" + new_nationality + "]";
	}
	

}
