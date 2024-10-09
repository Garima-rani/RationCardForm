package com.example.service;

//import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    @jakarta.annotation.PostConstruct
    public void init() {
        // Initialize Twilio with account SID and Auth Token
        Twilio.init(accountSid, authToken);
    }

    public void sendOtp(String toPhoneNumber, String otp) {
        Message.creator(
                new PhoneNumber(toPhoneNumber), // To
                new PhoneNumber(fromPhoneNumber), // From
                "Your OTP code is: " + otp // Message
        ).create();
    }
}
