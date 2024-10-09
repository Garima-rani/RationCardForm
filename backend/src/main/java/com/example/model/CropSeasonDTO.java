package com.example.model;

public class CropSeasonDTO {
private Long id;
private String cropSeasonName;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCropSeasonName() {
	return cropSeasonName;
}
public void setCropSeasonName(String cropSeasonName) {
	this.cropSeasonName = cropSeasonName;
}
public CropSeasonDTO(Long id, String cropSeasonName) {
	super();
	this.id = id;
	this.cropSeasonName = cropSeasonName;
}

}
