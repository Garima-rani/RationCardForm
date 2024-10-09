package com.example.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NewDob {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date dob;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public NewDob() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewDob(Long id, Date dob) {
		super();
		this.id = id;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "NewDob [id=" + id + ", dob=" + dob + "]";
	}

	
	

}
