package com.example.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class GasDetails {
    private String gasConnectionStatus;
    private String company;
    private String agency;
    private String consumer;

    public String getGasConnectionStatus() {
        return gasConnectionStatus;
    }

    public void setGasConnectionStatus(String gasConnectionStatus) {
        this.gasConnectionStatus = gasConnectionStatus;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

}
