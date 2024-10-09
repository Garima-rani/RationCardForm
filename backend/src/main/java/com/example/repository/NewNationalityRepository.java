package com.example.repository;

import com.example.model.NewNationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewNationalityRepository extends JpaRepository<NewNationality, Long> {
    // Additional query methods can be defined here if needed
}
