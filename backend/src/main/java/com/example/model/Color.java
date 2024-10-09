package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "color_master")
public class Color {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="color_name")
private String colorName;

@Column(name="hex_code")
private String hexCode;

@Column(name="remarks")
private String remarks;

@Column(name="status")
private String status;

// Getters and Setters

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getColorName() {
    return colorName;
}

public void setColorName(String colorName) {
    this.colorName = colorName;
}

public String getHexCode() {
    return hexCode;
}

public void setHexCode(String hexCode) {
    this.hexCode = hexCode;
}

public String getRemarks() {
    return remarks;
}

public void setRemarks(String remarks) {
    this.remarks = remarks;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

public Color() {
	super();
	// TODO Auto-generated constructor stub
}

public Color(Long id, String colorName, String hexCode, String remarks, String status) {
	super();
	this.id = id;
	this.colorName = colorName;
	this.hexCode = hexCode;
	this.remarks = remarks;
	this.status = status;
}

@Override
public String toString() {
	return "Color [id=" + id + ", colorName=" + colorName + ", hexCode=" + hexCode + ", remarks=" + remarks
			+ ", status=" + status + "]";
}

}
