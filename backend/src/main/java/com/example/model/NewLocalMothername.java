package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class NewLocalMothername {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String local_mothername;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NewLocalMothername() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewLocalMothername(Long id, String local_mothername) {
		super();
		this.id = id;
		this.local_mothername = local_mothername;
	}

	@Override
	public String toString() {
		return "NewLocalMothername [id=" + id + ", local_mothername=" + local_mothername + "]";
	}
	


}
