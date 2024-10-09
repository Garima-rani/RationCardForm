package com.example.model;




import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Otp {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String aadharNumber;
 private String otpCode;
 private LocalDateTime expiresAt;
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
public String getOtpCode() {
	return otpCode;
}
public void setOtpCode(String otpCode) {
	this.otpCode = otpCode;
}
public LocalDateTime getExpiresAt() {
	return expiresAt;
}
public void setExpiresAt(LocalDateTime expiresAt) {
	this.expiresAt = expiresAt;
}
public Otp() {
	super();
	// TODO Auto-generated constructor stub
}
public Otp(Long id, String aadharNumber, String otpCode, LocalDateTime expiresAt) {
	super();
	this.id = id;
	this.aadharNumber = aadharNumber;
	this.otpCode = otpCode;
	this.expiresAt = expiresAt;
}
@Override
public String toString() {
	return "Otp [id=" + id + ", aadharNumber=" + aadharNumber + ", otpCode=" + otpCode + ", expiresAt=" + expiresAt
			+ "]";
}

 
}
