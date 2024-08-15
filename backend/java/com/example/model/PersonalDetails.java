package com.example.model;

import java.sql.Date;

import jakarta.persistence.Embeddable;

@Embeddable
public class PersonalDetails {
    private String profilePicture;
    private String name;
    private String localName;
    private String gender;
    private Date dob;
    private String motherName;
    private String localMotherName;
    private String fatherName;
    private String localFatherName;
    private String maritalStatus;
    private String nationality;
    private String mobileNo;
    private String email;

    // Other fields, getters, setters
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

 


	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getLocalMotherName() {
		return localMotherName;
	}

	public void setLocalMotherName(String localMotherName) {
		this.localMotherName = localMotherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getLocalFatherName() {
		return localFatherName;
	}

	public void setLocalFatherName(String localFatherName) {
		this.localFatherName = localFatherName;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    

}
