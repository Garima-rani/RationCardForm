package com.example.model;

public class LanguageDTO {
	private Long id;
	private String languageName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public LanguageDTO(Long id, String languageName) {
		super();
		this.id = id;
		this.languageName = languageName;
	}
	
	

}
