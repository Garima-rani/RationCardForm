package com.example.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class AdditionalDetails {
    private String oldRc;
    private String bplNo;

    public String getOldRc() {
        return oldRc;
    }

    public void setOldRc(String oldRc) {
        this.oldRc = oldRc;
    }

    public String getBplNo() {
        return bplNo;
    }

    public void setBplNo(String bplNo) {
        this.bplNo = bplNo;
    }

}
