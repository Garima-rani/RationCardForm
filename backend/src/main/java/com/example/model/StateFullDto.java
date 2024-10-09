package com.example.model;

public class StateFullDto {
	
	  private Long id;
	    private String stateName;
	    private String stateCode;
	    private String localName;
	    private String shortName;
	    private String stateUnionTerritory;
	    private Boolean dbt;
	    private byte[] document;
	    private Boolean centralProgramsState;
	    private Boolean availableOnMobileApp;
	    private Boolean rcmsHostedOnNfsaPortal;
	    private Boolean commonRegistrationFacilityForRcAvailable;
	    private Boolean availableForFpsMobileSaleApp;
	    private String status;
	    private String description;

	    private ProcurementTypeDTO procurementType;
	    private CategoryDTO category;
	    private OwnershipTypeDTO ownershipType;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getStateName() {
			return stateName;
		}
		
		public byte[] getDocument() {
			return document;
		}
		public void setDocument(byte[] document) {
			this.document = document;
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
		public ProcurementTypeDTO getProcurementType() {
			return procurementType;
		}
		public void setProcurementType(ProcurementTypeDTO procurementType) {
			this.procurementType = procurementType;
		}
		public CategoryDTO getCategory() {
			return category;
		}
		public void setCategory(CategoryDTO category) {
			this.category = category;
		}
		public OwnershipTypeDTO getOwnershipType() {
			return ownershipType;
		}
		public void setOwnershipType(OwnershipTypeDTO ownershipType) {
			this.ownershipType = ownershipType;
		}
		public StateFullDto(Long id, String stateName, String stateCode, String localName, String shortName,
				String stateUnionTerritory, Boolean dbt, byte[] document, Boolean centralProgramsState,
				Boolean availableOnMobileApp, Boolean rcmsHostedOnNfsaPortal,
				Boolean commonRegistrationFacilityForRcAvailable, Boolean availableForFpsMobileSaleApp, String status,
				String description, ProcurementTypeDTO procurementType, CategoryDTO category,
				OwnershipTypeDTO ownershipType) {
			super();
			this.id = id;
			this.stateName = stateName;
			this.stateCode = stateCode;
			this.localName = localName;
			this.shortName = shortName;
			this.stateUnionTerritory = stateUnionTerritory;
			this.dbt = dbt;
			this.document = document;
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
		}
		
	    
	    

}
