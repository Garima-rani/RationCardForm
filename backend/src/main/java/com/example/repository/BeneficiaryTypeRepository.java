package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.BeneficiaryType;
@Repository
public interface BeneficiaryTypeRepository extends JpaRepository<BeneficiaryType, Long> {

	List<BeneficiaryType> findAll();

}
