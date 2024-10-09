package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.AadharUser;

public interface AadharUserRepository extends JpaRepository<AadharUser, Long> {
    AadharUser findByAadharNumber(String aadharNumber);
}
