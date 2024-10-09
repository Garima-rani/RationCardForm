package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.service.CaptchaService;
import com.example.service.OtpService;
//import com.example.service.OtpService;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private CaptchaService captchaService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateOtp(@RequestParam String aadharNumber, @RequestParam String captchaValue) {
        if (!captchaService.validateCaptcha(captchaValue)) {
            return ResponseEntity.badRequest().body("Invalid CAPTCHA.");
        }

        try {
            otpService.sendOtpToUser(aadharNumber);
            return ResponseEntity.ok().body("OTP sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating OTP.");
        }
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateOtp(@RequestParam String aadharNumber, @RequestParam String otpCode) {
        boolean isValid = otpService.validateOtp(aadharNumber, otpCode);
        return ResponseEntity.ok(isValid);
    }
}
