package com.example.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "states")  // Map to the 'states' table
public class States {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "state_name", nullable = false)
    private String stateName;
  
    @Column(name = "code")
    private String stateCode;
    
    @Column(name = "local_name")
    private String localName;
    
    @Column(name = "short_name")
    private String shortName;
    
    @Column(name = "state_union_territory")
    private String stateUnionTerritory;
    
    @Column(name = "dbt")
    private Boolean dbt;
    
    @Column(name = "central_programs_state")
    private Boolean centralProgramsState;
    
    @Column(name = "available_on_mobile_app")
    private Boolean availableOnMobileApp;
    
    @Column(name = "rcms_hosted_on_nfsa_portal")
    private Boolean rcmsHostedOnNfsaPortal;
    
    @Column(name = "common_registration_facility_for_rc_available")
    private Boolean commonRegistrationFacilityForRcAvailable;
    
    @Column(name = "available_for_fps_mobile_sale_app")
    private Boolean availableForFpsMobileSaleApp;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "procurement_type_id")
    private ProcurementType procurementType;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "ownership_type_id")
    private OwnershipType ownershipType;
    
   
    @Column(name="document")// Use @Lob annotation for BLOB handling
    private byte[] document; // BLOB field
    
    @ManyToMany
    @JoinTable(
        name = "language_states",
        joinColumns = @JoinColumn(name = "state_id"),
        inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages = new HashSet<>();
   
    
    @OneToMany(mappedBy = "state")
    @JsonManagedReference
    @ToString.Exclude
    private List<MeasurementUnit> measurementUnits;

	public Long getId() {
		return id;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getStateUnionTerritory() {
		return stateUnionTerritory;
	}

	public void setStateUnionTerritory(String stateUnionTerritory) {
		this.stateUnionTerritory = stateUnionTerritory;
	}

	public Boolean getDbt() {
		return dbt;
	}

	public void setDbt(Boolean dbt) {
		this.dbt = dbt;
	}

	public Boolean getCentralProgramsState() {
		return centralProgramsState;
	}

	public void setCentralProgramsState(Boolean centralProgramsState) {
		this.centralProgramsState = centralProgramsState;
	}

	public Boolean getAvailableOnMobileApp() {
		return availableOnMobileApp;
	}

	public void setAvailableOnMobileApp(Boolean availableOnMobileApp) {
		this.availableOnMobileApp = availableOnMobileApp;
	}

	public Boolean getRcmsHostedOnNfsaPortal() {
		return rcmsHostedOnNfsaPortal;
	}

	public void setRcmsHostedOnNfsaPortal(Boolean rcmsHostedOnNfsaPortal) {
		this.rcmsHostedOnNfsaPortal = rcmsHostedOnNfsaPortal;
	}

	public Boolean getCommonRegistrationFacilityForRcAvailable() {
		return commonRegistrationFacilityForRcAvailable;
	}

	public void setCommonRegistrationFacilityForRcAvailable(Boolean commonRegistrationFacilityForRcAvailable) {
		this.commonRegistrationFacilityForRcAvailable = commonRegistrationFacilityForRcAvailable;
	}

	public Boolean getAvailableForFpsMobileSaleApp() {
		return availableForFpsMobileSaleApp;
	}

	public void setAvailableForFpsMobileSaleApp(Boolean availableForFpsMobileSaleApp) {
		this.availableForFpsMobileSaleApp = availableForFpsMobileSaleApp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProcurementType getProcurementType() {
		return procurementType;
	}

	public void setProcurementType(ProcurementType procurementType) {
		this.procurementType = procurementType;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public OwnershipType getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(OwnershipType ownershipType) {
		this.ownershipType = ownershipType;
	}


	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	public States() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public States(Long id, String stateName, String stateCode, String localName, String shortName,
			String stateUnionTerritory, Boolean dbt, Boolean centralProgramsState, Boolean availableOnMobileApp,
			Boolean rcmsHostedOnNfsaPortal, Boolean commonRegistrationFacilityForRcAvailable,
			Boolean availableForFpsMobileSaleApp, String status, String description, ProcurementType procurementType,
			Category category, OwnershipType ownershipType, byte[] document, Set<Language> languages) {
		super();
		this.id = id;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.localName = localName;
		this.shortName = shortName;
		this.stateUnionTerritory = stateUnionTerritory;
		this.dbt = dbt;
		this.centralProgramsState = centralProgramsState;
		this.availableOnMobileApp = availableOnMobileApp;
		this.rcmsHostedOnNfsaPortal = rcmsHostedOnNfsaPortal;
		this.commonRegistrationFacilityForRcAvailable = commonRegistrationFacilityForRcAvailable;
		this.availableForFpsMobileSaleApp = availableForFpsMobileSaleApp;
		this.status = status;
		this.description = description;
		this.procurementType = procurementType;
		this.category = category;
		this.ownershipType = ownershipType;
		this.document = document;
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "States [id=" + id + ", stateName=" + stateName + ", stateCode=" + stateCode + ", localName=" + localName
				+ ", shortName=" + shortName + ", stateUnionTerritory=" + stateUnionTerritory + ", dbt=" + dbt
				+ ", centralProgramsState=" + centralProgramsState + ", availableOnMobileApp=" + availableOnMobileApp
				+ ", rcmsHostedOnNfsaPortal=" + rcmsHostedOnNfsaPortal + ", commonRegistrationFacilityForRcAvailable="
				+ commonRegistrationFacilityForRcAvailable + ", availableForFpsMobileSaleApp="
				+ availableForFpsMobileSaleApp + ", status=" + status + ", description=" + description
				+ ", procurementType=" + procurementType + ", category=" + category + ", ownershipType=" + ownershipType
				+ ", document=" + document + ", languages=" + languages + "]";
	}

	
}
