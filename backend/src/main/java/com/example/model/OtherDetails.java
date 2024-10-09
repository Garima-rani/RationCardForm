package com.example.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class OtherDetails {
    private String casteCategory;
    private String casteCategoryCertificate;
    private String houseType;

    public String getCasteCategory() {
        return casteCategory;
    }

    public void setCasteCategory(String casteCategory) {
        this.casteCategory = casteCategory;
    }

    public String getCasteCategoryCertificate() {
        return casteCategoryCertificate;
    }

    public void setCasteCategoryCertificate(String casteCategoryCertificate) {
        this.casteCategoryCertificate = casteCategoryCertificate;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

}
