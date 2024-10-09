package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NewLocalFathername {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String local_fathername;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocal_fathername() {
		return local_fathername;
	}

	public void setLocal_fathername(String local_fathername) {
		this.local_fathername = local_fathername;
	}

	public NewLocalFathername() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewLocalFathername(Long id, String local_fathername) {
		super();
		this.id = id;
		this.local_fathername = local_fathername;
	}

	@Override
	public String toString() {
		return "NewLocalFathername [id=" + id + ", local_fathername=" + local_fathername + "]";
	}
	
	

}
