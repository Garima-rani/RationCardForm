package com.example.model;

import java.util.Set;

public class AuthResponse {
    private String token;
    private String username;
    private Set<String> roles; // Add roles field to store user's roles

    public AuthResponse(String token, String username, Set<String> roles) {
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuthResponse [token=" + token + ", username=" + username + ", roles=" + roles + "]";
	}
    
}
