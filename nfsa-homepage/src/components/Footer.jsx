// src/components/Footer.js
import React from 'react';
import './Footer.css';

const Footer = () => {
  return (
    <footer className="footer">
      <div className="links">
        <a href="/">Privacy Policy</a>
        <a href="/">Terms of Service</a>
        <a href="/">Contact Us</a>
      </div>
      <p>&copy; 2024 National Food Security Portal</p>
    </footer>
  );
};

export default Footer;
