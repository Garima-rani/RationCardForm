package com.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.AadharUserRepository;
import com.example.repository.UserRepository;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class OtpService {

    private static final String CHARACTERS = "0123456789";
    private static final int OTP_LENGTH = 6;
    private final Map<String, String> otpStore = new HashMap<>();  // Temporary storage for OTPs

    @Autowired
    private AadharUserRepository aadharUserRepository;

    @Autowired
    private SmsService smsService;

    public void sendOtpToUser(String aadharNumber) throws Exception {
        String mobileNumber = aadharUserRepository.findByAadharNumber(aadharNumber).getMobileNumber();
        if (mobileNumber == null) {
            throw new Exception("No mobile number linked to this Aadhaar number");
        }

        String otp = generateOtp();
        smsService.sendOtp(mobileNumber, otp);
        otpStore.put(aadharNumber, otp);
    }

    public boolean validateOtp(String aadharNumber, String otpCode) {
        String storedOtp = otpStore.get(aadharNumber);
        return otpCode.equals(storedOtp);
    }

    public String generateOtp() {
        SecureRandom random = new SecureRandom();
        StringBuilder otp = new StringBuilder(OTP_LENGTH);

        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return otp.toString();
    }
}
