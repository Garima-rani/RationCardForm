package com.example.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CaptchaService {

 @Value("${recaptcha.secretKey}")
 private String secretKey;

 public boolean validateCaptcha(String captchaValue) {
     String url = "https://www.google.com/recaptcha/api/siteverify";
     String params = String.format("secret=%s&response=%s", secretKey, captchaValue);

     RestTemplate restTemplate = new RestTemplate();
     CaptchaResponse response = restTemplate.postForObject(url, params, CaptchaResponse.class);

     return response != null && response.isSuccess();
 }

 private static class CaptchaResponse {
     private boolean success;
     private String challenge_ts;
     private String hostname;

     public boolean isSuccess() {
         return success;
     }

     public void setSuccess(boolean success) {
         this.success = success;
     }
 }
}
