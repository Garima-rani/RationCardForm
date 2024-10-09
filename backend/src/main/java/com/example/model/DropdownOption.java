package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DropdownOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;
    private String label;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public DropdownOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DropdownOption(Long id, String value, String label) {
		super();
		this.id = id;
		this.value = value;
		this.label = label;
	}
	@Override
	public String toString() {
		return "DropdownOption [id=" + id + ", value=" + value + ", label=" + label + "]";
	}

}

