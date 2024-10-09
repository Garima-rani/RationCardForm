package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Nationality;

@Repository
public interface NationalityRepository extends JpaRepository<Nationality, Long>{
	

}
