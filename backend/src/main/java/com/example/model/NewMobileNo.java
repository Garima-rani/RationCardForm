package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NewMobileNo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String new_mobile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNew_mobile() {
		return new_mobile;
	}

	public void setNew_mobile(String new_mobile) {
		this.new_mobile = new_mobile;
	}

	public NewMobileNo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewMobileNo(Long id, String new_mobile) {
		super();
		this.id = id;
		this.new_mobile = new_mobile;
	}

	@Override
	public String toString() {
		return "NewMobileNo [id=" + id + ", new_mobile=" + new_mobile + "]";
	}
	

}
