package com.example.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PersonalDetails personalDetails;

    @ManyToOne
    @JoinColumn(name = "present_state_id")
    private State presentState;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "state", column = @Column(name = "present_state")),
        @AttributeOverride(name = "address", column = @Column(name = "present_address")),
        @AttributeOverride(name = "district", column = @Column(name = "present_district")),
        @AttributeOverride(name = "town", column = @Column(name = "present_town")),
        @AttributeOverride(name = "tahsil", column = @Column(name = "present_tahsil"))
    })
    private PresentAddress presentAddress;


    @ManyToOne
    @JoinColumn(name = "permanent_state_id")
    private State permanentState;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "state", column = @Column(name = "permanent_state")),
        @AttributeOverride(name = "address", column = @Column(name = "permanent_address")),
        @AttributeOverride(name = "district", column = @Column(name = "permanent_district")),
        @AttributeOverride(name = "town", column = @Column(name = "permanent_town")),
        @AttributeOverride(name = "tahsil", column = @Column(name = "permanent_tahsil"))
    })
    private PermanentAddress permanentAddress;

     
    @Embedded
    private BankDetails bankDetails;

   @Embedded
    private ElectricityDetails electricityDetails;

    @Embedded
    private GasDetails gasDetails;

    @Embedded
    private CardType cardType;


    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "certificate", column = @Column(name = "professional_certificate"))
    })
    private ProfessionalDetails professionalDetails;

    @Embedded
    private IllnessDetails illnessDetails;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "percentage", column = @Column(name = "physical_percentage")),
        @AttributeOverride(name = "since", column = @Column(name = "physical_since")),
        @AttributeOverride(name = "year", column = @Column(name = "physical_year"))
            
    })
    private PhysicalDetails physicalDetails;


    @Embedded
    private GeneralDetails generalDetails;
    
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "certificate", column = @Column(name = "additional_certificate"))
    })
    private AdditionalDetails additionalDetails;


   @Embedded
    private OtherDetails otherDetails;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members;

    // Constructors
    public Form() {}

    public Form(Long id, PersonalDetails personalDetails, State presentState, PresentAddress presentAddress,
                State permanentState, PermanentAddress permanentAddress, BankDetails bankDetails, ElectricityDetails electricityDetails,
                GasDetails gasDetails, CardType cardType, ProfessionalDetails professionalDetails, IllnessDetails illnessDetails,
                PhysicalDetails physicalDetails, GeneralDetails generalDetails, AdditionalDetails additionalDetails,
                OtherDetails otherDetails, List<Member> members) {
        this.id = id;
        this.personalDetails = personalDetails;
        this.presentState = presentState;
        this.presentAddress = presentAddress;
        this.permanentState = permanentState;
        this.permanentAddress = permanentAddress;
        this.bankDetails = bankDetails;
        this.electricityDetails = electricityDetails;
        this.gasDetails = gasDetails;
        this.cardType = cardType;
        this.professionalDetails = professionalDetails;
        this.illnessDetails = illnessDetails;
        this.physicalDetails = physicalDetails;
        this.generalDetails = generalDetails;
        this.additionalDetails = additionalDetails;
        this.otherDetails = otherDetails;
        this.members = members;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public PersonalDetails getPersonalDetails() { return personalDetails; }
    public void setPersonalDetails(PersonalDetails personalDetails) { this.personalDetails = personalDetails; }

    public State getPresentState() { return presentState; }
    public void setPresentState(State presentState) { this.presentState = presentState; }

    public PresentAddress getPresentAddress() { return presentAddress; }
    public void setPresentAddress(PresentAddress presentAddress) { this.presentAddress = presentAddress; }

    public State getPermanentState() { return permanentState; }
    public void setPermanentState(State permanentState) { this.permanentState = permanentState; }

    public PermanentAddress getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(PermanentAddress permanentAddress) { this.permanentAddress = permanentAddress; }

    public BankDetails getBankDetails() { return bankDetails; }
    public void setBankDetails(BankDetails bankDetails) { this.bankDetails = bankDetails; }

    public ElectricityDetails getElectricityDetails() { return electricityDetails; }
    public void setElectricityDetails(ElectricityDetails electricityDetails) { this.electricityDetails = electricityDetails; }

    public GasDetails getGasDetails() { return gasDetails; }
    public void setGasDetails(GasDetails gasDetails) { this.gasDetails = gasDetails; }

    public CardType getCardType() { return cardType; }
    public void setCardType(CardType cardType) { this.cardType = cardType; }

    public ProfessionalDetails getProfessionalDetails() { return professionalDetails; }
    public void setProfessionalDetails(ProfessionalDetails professionalDetails) { this.professionalDetails = professionalDetails; }

    public IllnessDetails getIllnessDetails() { return illnessDetails; }
    public void setIllnessDetails(IllnessDetails illnessDetails) { this.illnessDetails = illnessDetails; }

    public PhysicalDetails getPhysicalDetails() { return physicalDetails; }
    public void setPhysicalDetails(PhysicalDetails physicalDetails) { this.physicalDetails = physicalDetails; }

    public GeneralDetails getGeneralDetails() { return generalDetails; }
    public void setGeneralDetails(GeneralDetails generalDetails) { this.generalDetails = generalDetails; }

    public AdditionalDetails getAdditionalDetails() { return additionalDetails; }
    public void setAdditionalDetails(AdditionalDetails additionalDetails) { this.additionalDetails = additionalDetails; }

    public OtherDetails getOtherDetails() { return otherDetails; }
    public void setOtherDetails(OtherDetails otherDetails) { this.otherDetails = otherDetails; }

    public List<Member> getMembers() { return members; }
    public void setMembers(List<Member> members) { this.members = members; }

    @Override
    public String toString() {
        return "Form [id=" + id + ", personalDetails=" + personalDetails + ", presentState=" + presentState
                + ", presentAddress=" + presentAddress + ", permanentState=" + permanentState
                + ", permanentAddress=" + permanentAddress + ", bankDetails=" + bankDetails
                + ", electricityDetails=" + electricityDetails + ", gasDetails=" + gasDetails
                + ", cardType=" + cardType + ", professionalDetails=" + professionalDetails
                + ", illnessDetails=" + illnessDetails + ", physicalDetails=" + physicalDetails
                + ", generalDetails=" + generalDetails + ", additionalDetails=" + additionalDetails
                + ", otherDetails=" + otherDetails + ", members=" + members + "]";
    }
}
