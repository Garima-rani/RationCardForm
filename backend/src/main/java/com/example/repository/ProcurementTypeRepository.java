package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.ProcurementType;

public interface ProcurementTypeRepository extends JpaRepository<ProcurementType, Long> {
}
