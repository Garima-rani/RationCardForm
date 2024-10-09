package com.example.repository;

import com.example.model.Form;
import com.example.model.Occupation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
	
}
