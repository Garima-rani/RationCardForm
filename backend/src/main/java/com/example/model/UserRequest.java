package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;

@Entity
public class UserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // The username of the user requesting access

    @Enumerated(EnumType.STRING)
    private ERole role; // The role requested by the user (e.g., USER, EDITOR, ADMIN)

    private String status; // Status of the request (e.g., PENDING, APPROVED, DECLINED)

    private LocalDateTime requestDate; // Date and time when the request was made

    // Constructors
    public UserRequest() {
    }

    public UserRequest(String username, ERole role, String status, LocalDateTime requestDate) {
        this.username = username;
        this.role = role;
        this.status = status;
        this.requestDate = requestDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public ERole getRole() { return role; }
    public void setRole(ERole role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }
}
