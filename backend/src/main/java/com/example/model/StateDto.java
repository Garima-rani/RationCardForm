package com.example.model;

public class StateDto {
	private Long id;
    private String stateName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public StateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StateDto(Long id, String stateName) {
		super();
		this.id = id;
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "StateDto [id=" + id + ", stateName=" + stateName + "]";
	}
    
    

}
