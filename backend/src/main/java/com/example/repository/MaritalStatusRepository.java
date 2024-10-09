package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.model.Gender;
import com.example.model.MaritalStatus;

@Repository
public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Long> {

}
