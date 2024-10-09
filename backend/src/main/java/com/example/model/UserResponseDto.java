package com.example.model;

import java.time.LocalDateTime;
import java.util.Set;

public class UserResponseDto {
    private Long id;
    private String username;
    private LocalDateTime createdAt;
    private Set<String> roles;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public UserResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponseDto(Long id, String username, LocalDateTime createdAt, Set<String> roles) {
		super();
		this.id = id;
		this.username = username;
		this.createdAt = createdAt;
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserResponseDto [id=" + id + ", username=" + username + ", createdAt=" + createdAt + ", roles=" + roles
				+ "]";
	}
    

}
