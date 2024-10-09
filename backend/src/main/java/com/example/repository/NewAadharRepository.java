package com.example.repository;

import com.example.model.New_Aadhar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewAadharRepository extends JpaRepository<New_Aadhar, Long> {
    // Additional query methods can be defined here if needed
}
