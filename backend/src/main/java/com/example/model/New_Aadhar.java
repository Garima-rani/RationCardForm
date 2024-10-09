package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class New_Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String newAadhar; 

    
    public New_Aadhar() {
    }

    // Parameterized constructor
    public New_Aadhar(Long id, String newAadhar) {
        this.id = id;
        this.newAadhar = newAadhar;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewAadhar() {
        return newAadhar;
    }

    public void setNewAadhar(String newAadhar) {
        this.newAadhar = newAadhar;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "New_Aadhar [id=" + id + ", newAadhar=" + newAadhar + "]";
    }
}
