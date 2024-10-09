package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Occupation;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, Long> {

}
