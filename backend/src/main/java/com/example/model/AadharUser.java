package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AadharUser {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String aadharNumber;
	    private String mobileNumber;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getAadharNumber() {
			return aadharNumber;
		}
		public void setAadharNumber(String aadharNumber) {
			this.aadharNumber = aadharNumber;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public AadharUser() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AadharUser(Long id, String aadharNumber, String mobileNumber) {
			super();
			this.id = id;
			this.aadharNumber = aadharNumber;
			this.mobileNumber = mobileNumber;
		}
		@Override
		public String toString() {
			return "AadharUser [id=" + id + ", aadharNumber=" + aadharNumber + ", mobileNumber=" + mobileNumber + "]";
		}
	    
}
