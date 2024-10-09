package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.OwnershipType;

public interface OwnershipTypeRepository extends JpaRepository<OwnershipType, Long> {
}
