package com.example.model;

import java.util.List;

public class StateWithLanguagesDto {
	 private Long id;
	    private String stateName;
	    private List<LanguageDTO> languages;
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
		public List<LanguageDTO> getLanguages() {
			return languages;
		}
		public void setLanguages(List<LanguageDTO> languages) {
			this.languages = languages;
		}
		public StateWithLanguagesDto(Long id, String stateName, List<LanguageDTO> languages) {
			super();
			this.id = id;
			this.stateName = stateName;
			this.languages = languages;
		}
	    
	    
}
