package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NewLocalUsername {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String local_username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocal_username() {
		return local_username;
	}

	public void setLocal_username(String local_username) {
		this.local_username = local_username;
	}

	public NewLocalUsername() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewLocalUsername(Long id, String local_username) {
		super();
		this.id = id;
		this.local_username = local_username;
	}

	@Override
	public String toString() {
		return "NewLocalUsername [id=" + id + ", local_username=" + local_username + "]";
	}
    
}
