import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Use useNavigate instead of useHistory
import './Header.css';
import Modal from '@mui/material/Modal';
import OfficialLogin from './OfficialLogin';
import AadharOtpLogin from './AadharOtpLogin'; // Import the AadharOtpLogin component
import { useDispatch, useSelector } from 'react-redux';
import { setToken } from '../redux/slices/authSlice';

function Header() {
  const {token} = useSelector(state =>state.auth) ;
  const dispatch = useDispatch() ; 
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const navigate = useNavigate(); // Initialize useNavigate
  const [modalOpen , setModalOpen] = useState(false) ;
  const [publicLoginModal , setPublicLoginModal] = useState(false) ;

  const handleOpen = ()=>{ setModalOpen(true) ;}
  const handleClose = ()=>{ setModalOpen(false) ;}

  const toggleDropdown = () => {
    setDropdownOpen(!dropdownOpen);
  };

  const logoutHandler = (e)=>{
    e.preventDefault() ;
    dispatch(setToken(null)) ; 

    localStorage.removeItem('token');
    navigate('/');
  }
  const handlePublicLogin = () => {
    setPublicLoginModal(true); // Show the Aadhar OTP component
    setDropdownOpen(false); // Close the dropdown menu
  };

  return (
    <div className="header-container">
      <div className="header-logo">
        <img src="/nfsa-logo.png" alt="NFSA Logo" />
      </div>
      <div className="header-title">
        <h1>National Food Security Portal</h1>
        <p>Department of Food & Public Distribution,<br /> Government of India</p>
      </div>
      <div className="header-buttons">
        <div className="header-lang">
         {token && <button onClick={()=> navigate("/add-form")}>Ration Card Form</button>}
        </div>
        {token ? <button onClick={logoutHandler} className='header-button'>Logout</button>:   <div className="dropdown">
          <button className="header-button" onClick={toggleDropdown}>
            Sign In / Register ⬇
          </button>
          {dropdownOpen && (
            <div className="dropdown-menu">
            <button className="dropdown-item" onClick={handlePublicLogin}>
                Public Login
              </button>
              <button className="dropdown-item" onClick={ ()=>{ setDropdownOpen(false);handleOpen()}}>
                Official Login
              </button>
              
            </div>
          )}
        </div>} 
      
        <button className="header-button">English</button>
      
      </div>
      <Modal
         open={modalOpen}
        onClose={handleClose}
        aria-labelledby="modal-title"
        aria-describedby="modal-description"
      >
        <OfficialLogin  onClose={handleClose}/>
      </Modal>

      {/* <Modal
         open={publicLoginModal}
        onClose={()=> setPublicLoginModal(false)}
        aria-labelledby="modal-title"
        aria-describedby="modal-description"
        
      >
        <AadharOtpLogin  onClose={handleClose}/>
      </Modal> */}
      {/* {showAadharOtp && <AadharOtpLogin />} Render the AadharOtpLogin component if showAadharOtp is true */}
    </div>
  );
}

export default Header;
