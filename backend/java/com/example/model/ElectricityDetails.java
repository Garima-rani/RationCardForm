package com.example.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class ElectricityDetails {
    private String companyName;
    private String consumerNo;

    // Other fields, getters, setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getConsumerNo() {
        return consumerNo;
    }

    public void setConsumerNo(String consumerNo) {
        this.consumerNo = consumerNo;
    }

}
