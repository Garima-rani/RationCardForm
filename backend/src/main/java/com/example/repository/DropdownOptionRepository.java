package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.DropdownOption;

public interface DropdownOptionRepository extends JpaRepository<DropdownOption, Long> {

	
}
