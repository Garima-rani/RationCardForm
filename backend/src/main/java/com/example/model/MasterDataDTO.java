package com.example.model;



import com.example.model.Category;
import com.example.model.OwnershipType;
import com.example.model.ProcurementType;

import java.util.List;

public class MasterDataDTO {
    private List<ProcurementType> procurementTypes;
    private List<Category> categories;
    private List<OwnershipType> ownershipTypes;

    // Constructors, Getters and Setters
    public MasterDataDTO(List<ProcurementType> procurementTypes, List<Category> categories, List<OwnershipType> ownershipTypes) {
        this.procurementTypes = procurementTypes;
        this.categories = categories;
        this.ownershipTypes = ownershipTypes;
    }

    public List<ProcurementType> getProcurementTypes() {
        return procurementTypes;
    }

    public void setProcurementTypes(List<ProcurementType> procurementTypes) {
        this.procurementTypes = procurementTypes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<OwnershipType> getOwnershipTypes() {
        return ownershipTypes;
    }

    public void setOwnershipTypes(List<OwnershipType> ownershipTypes) {
        this.ownershipTypes = ownershipTypes;
    }
}
