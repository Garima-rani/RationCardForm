package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class NewLoginID {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;

   

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

	public NewLoginID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewLoginID(Long id, String loginId) {
		super();
		this.id = id;
		this.loginId = loginId;
	}

	@Override
	public String toString() {
		return "NewLoginID [id=" + id + ", loginId=" + loginId + "]";
	}
    

}
