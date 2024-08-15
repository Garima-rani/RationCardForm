package com.example.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class GeneralDetails {
    private String epic;
    private String npr;
    private Boolean hasMNREGA;
    private String MNREGA;
    
    private Boolean hasAadhar;
    private String aadharNo;
    private Boolean hasAadharEnrollment;
 
    private String aadharEnrollmentNo;

	public String getEpic() {
		return epic;
	}

	public void setEpic(String epic) {
		this.epic = epic;
	}

	public String getNpr() {
		return npr;
	}

	public void setNpr(String npr) {
		this.npr = npr;
	}

	public Boolean getHasMNREGA() {
		return hasMNREGA;
	}

	public void setHasMNREGA(Boolean hasMNREGA) {
		this.hasMNREGA = hasMNREGA;
	}

	public String getMNREGA() {
		return MNREGA;
	}

	public void setMNREGA(String mNREGA) {
		MNREGA = mNREGA;
	}

	public Boolean getHasAadhar() {
		return hasAadhar;
	}

	public void setHasAadhar(Boolean hasAadhar) {
		this.hasAadhar = hasAadhar;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public Boolean getHasAadharEnrollment() {
		return hasAadharEnrollment;
	}

	public void setHasAadharEnrollment(Boolean hasAadharEnrollment) {
		this.hasAadharEnrollment = hasAadharEnrollment;
	}

	public String getAadharEnrollmentNo() {
		return aadharEnrollmentNo;
	}

	public void setAadharEnrollmentNo(String aadharEnrollmentNo) {
		this.aadharEnrollmentNo = aadharEnrollmentNo;
	}
  

}
