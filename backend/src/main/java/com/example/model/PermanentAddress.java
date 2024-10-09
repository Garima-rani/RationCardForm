package com.example.model;

import jakarta.persistence.Embeddable;


	@Embeddable
	public class PermanentAddress {
	    private String state;
	    private String district;
	    private String tahsil;
	    private String town;
	    private String address;
	    private String landmark ;
	    private int pin ; 

	    // Other fields, getters, setters
	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }

	    public String getDistrict() {
	        return district;
	    }

	    public void setDistrict(String district) {
	        this.district = district;
	    }

	    public String getTahsil() {
	        return tahsil;
	    }

	    public void setTahsil(String tahsil) {
	        this.tahsil = tahsil;
	    }

	    public String getTown() {
	        return town;
	    }

	    public void setTown(String town) {
	        this.town = town;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public String getLandmark() {
			return landmark;
		}

		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}

		public int getPin() {
			return pin;
		}

		public void setPin(int pin) {
			this.pin = pin;
		}

		public void setAddress(String address) {
	        this.address = address;
	    }
	}

