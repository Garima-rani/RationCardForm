// src/components/AadhaarOtpLogin.js
import React, { useState } from 'react';
import axios from 'axios';
import ReCAPTCHA from 'react-google-recaptcha';
import Box from '@mui/material/Box';
import Input from './common/Input';

const AadhaarOtpLogin = () => {
  const [aadharNo, setAadharNo] = useState('');
  const [captchaValue, setCaptchaValue] = useState(null);
  const [otp, setOtp] = useState('');
  const [message, setMessage] = useState('');

  const recaptchaRef = React.createRef();

  const handleGenerateOtp = async (e) => {
    e.preventDefault()
    if (!aadharNo || !captchaValue) {
      setMessage('Please complete the CAPTCHA.');
      return;
    }

    try {
      const response = await axios.post('/api/otp/generate', {
        aadharNumber: aadharNo,
        captchaValue: captchaValue,
      });

      setMessage(response.data.message);
    } catch (error) {
      setMessage('Error generating OTP.');
    }
  };

  const handleValidateOtp = async (e) => {
        e.preventDefault() ; 
    try {
      const response = await axios.post('/api/otp/validate', {
        aadharNumber: aadharNo,
        otpCode: otp,
      });

      if (response.data) {
        setMessage('Login successful!');
        // Redirect to a different page or handle login success
      } else {
        setMessage('Invalid OTP.');
      }
    } catch (error) {
      setMessage('Error validating OTP.');
    }
  };

  const onCaptchaChange = (value) => {
    setCaptchaValue(value);
  };

  return (
    <Box
    sx={{
      position: 'absolute',
      top: '50%',
      left: '50%',
      transform: 'translate(-50%, -50%)',
      bgcolor: 'black',
      boxShadow: 24,
      // borderRadius : "20px" , 
      
    }}
  >
    <form className="aadhaar-otp-login min-w-[500px]  bg-[whitesmoke] rounded-md p-4 flex flex-col gap-2 w-full max-w-lg ">
      <h2 className='text-2xl mb-10 text-center'>Aadhaar OTP Login</h2>
      <Input
        label="Enter Aadhar Number"
        className="bg-white rounded-md"
        type="text"
        placeholder="Enter Aadhaar Number"
        value={aadharNo}
        onChange={(e) => setAadharNo(e.target.value)}
      />
      <ReCAPTCHA
        sitekey="6LdDVjYqAAAAAMs9LZer6wJ39M29yVX-BJ7jd7MV"
        onChange={onCaptchaChange}
        ref={recaptchaRef}
      />
      <button onClick={handleGenerateOtp} className='bg-blue-400 text-white p-2 rounded-md'>Generate OTP</button>
      <input
        type="text"
        placeholder="Enter OTP"
        value={otp}
        onChange={(e) => setOtp(e.target.value)}
      />
      <button onClick={handleValidateOtp} className='bg-green-400 text-white p-2 rounded-md'>Validate OTP</button>
      <p>{message}</p>
    </form>
    </Box>
  );
};

export default AadhaarOtpLogin;
