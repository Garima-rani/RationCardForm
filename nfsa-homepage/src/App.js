import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import CarouselComponent from './components/Carousel.jsx';
import StatsSection from './components/StatsSection.jsx';
import ProtectedRoute from './components/ProtectedRoute.jsx'; // Ensure this path is correct
import HeaderNavLayout from './layout/HeaderNavLayout.jsx';
import AadharOtpLogin from './components/AadharOtpLogin.jsx';
import NewOfficialRegister from './forms/NewOfficialRegister.jsx';
import FormPage from "./pages/FormPage.jsx"
import UserHome from './pages/UserHome.jsx';
import { useSelector } from 'react-redux';
import Master from './components/core/Master.jsx';
import LoggedInLayout from './layout/LoggedInLayout.jsx';

const App = () => {

  const {token} =useSelector(state => state.auth) ; 


 
  return (
    <div>
      
      <Router>
        <Routes>
     
        {token ? (<Route element={<LoggedInLayout />} >
          <Route path="/" element={<UserHome />}></Route>
        <Route path="/master/data" element={<ProtectedRoute > <Master /></ProtectedRoute>} />
          
          
        </Route>) : (<Route element={<HeaderNavLayout/>}>
          <Route path="/" element={<><CarouselComponent />
            <StatsSection  /></>}/>
          
         </Route>) }
        <Route element={<HeaderNavLayout />}>
       
        {/* <Route path="/official-login" element={<OfficialLogin />} /> */}
        <Route path="/new/official/registration" element={<NewOfficialRegister />} />
            <Route path="/add-form" element={<FormPage />}/>
        <Route path="/aadhar-otp-login" element={<AadharOtpLogin />} />
        </Route>
        </Routes>
       
     
    </Router>
    </div>
  );
};

export default App;
