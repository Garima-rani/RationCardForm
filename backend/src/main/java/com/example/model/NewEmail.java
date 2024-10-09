package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NewEmail {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String new_email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNew_email() {
		return new_email;
	}

	public void setNew_email(String new_email) {
		this.new_email = new_email;
	}

	public NewEmail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewEmail(Long id, String new_email) {
		super();
		this.id = id;
		this.new_email = new_email;
	}

	@Override
	public String toString() {
		return "NewEmail [id=" + id + ", new_email=" + new_email + "]";
	}

	

}
