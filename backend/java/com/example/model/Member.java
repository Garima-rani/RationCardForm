package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form;
    
    private PersonalDetails personalDetails ;
    private GeneralDetails generalDetails ;
    private AdditionalDetails additionalDetails ;
    private ProfessionalDetails professionalDetails ;
    

    @Override
	public String toString() {
		return "Member [id=" + id + ", form=" + form + ", personalDetails=" + personalDetails + ", generalDetails="
				+ generalDetails + ", additionalDetails=" + additionalDetails + ", professionalDetails="
				+ professionalDetails + "]";
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(Long id, Form form, PersonalDetails personalDetails, GeneralDetails generalDetails,
			AdditionalDetails additionalDetails, ProfessionalDetails professionalDetails) {
		super();
		
		System.out.print(form + "Form") ; 
		this.id = id;
		this.form = form;
		this.personalDetails = personalDetails;
		this.generalDetails = generalDetails;
		this.additionalDetails = additionalDetails;
		this.professionalDetails = professionalDetails;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public GeneralDetails getGeneralDetails() {
		return generalDetails;
	}

	public void setGeneralDetails(GeneralDetails generalDetails) {
		this.generalDetails = generalDetails;
	}

	public AdditionalDetails getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(AdditionalDetails additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	public ProfessionalDetails getProfessionalDetails() {
		return professionalDetails;
	}

	public void setProfessionalDetails(ProfessionalDetails professionalDetails) {
		this.professionalDetails = professionalDetails;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    
    // Other fields, getters, setters
}
