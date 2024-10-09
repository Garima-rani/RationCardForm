package com.example.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class ProfessionalDetails {
	private String occupation ;
	private int income ;
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}

}
