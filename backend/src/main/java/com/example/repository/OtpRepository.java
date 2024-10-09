package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Otp;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {
 Optional<Otp> findByAadharNumberAndOtpCode(String aadharNumber, String otpCode);
}

