import React, { useState } from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
import axios from 'axios';
import Box from '@mui/material/Box';
import { setRole, setToken } from '../redux/slices/authSlice';
import { useDispatch } from 'react-redux';


const OfficialLogin = ({onClose}) => {
  const [credentials, setCredentials] = useState({ username: '', password: '' });
  const [error, setError] = useState('');
  const navigate = useNavigate();
  const dispatch = useDispatch() ;

  const handleChange = (e) => {
    setCredentials({ ...credentials, [e.target.name]: e.target.value });
  };

  const handleLogin = async () => {
    try {
        console.log(credentials , "cred") ;
        console.log(credentials);
       
      const response = await axios.post(
        'http://localhost:8080/api/auth/official-login', // Ensure the correct URL
        credentials
         // {
         //   headers: {
         //     'Content-Type': 'application/json',
         //   },
        // }
      );
      console.log(response , "resp");
     const token = response?.data?.token ;
     const role = response?.data?.roles[0] ;
      if(token){
      dispatch(setToken(response.data.token) );
      dispatch(setRole(role)) ; 
      localStorage.setItem("role" , role) ; 
      localStorage.setItem("token" , response.data.token)
      onClose() ; 
      setError(null) ; 
      // navigate('/master/data');

    } else {
        setError('Invalid ID or Password');
      }
    } catch (error) {
      setError('Login failed. Please try again.');
    }
  };

  return (
    <Box
    sx={{
      position: 'absolute',
      top: '50%',
      left: '50%',
      transform: 'translate(-50%, -50%)',
      
      bgcolor: 'gray',
      boxShadow: 24,
      // borderRadius : "20px" , 
      
    }}
  >
      <div className="w-full  bg-gray-200 rounded-lg shadow-lg p-4 grid lg:grid-cols-[60%_40%] gap-8 ">
        <div>

        <h2 className="text-2xl font-semibold text-center text-gray-800 rounded-lg h-[70px] flex justify-center items-center text-white bg-blue-400 ">PDS Login</h2>
        {error && (
          <div className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mt-4" role="alert">
            <strong className="font-bold">Error:</strong>
            <span className="block sm:inline"> {error}</span>
          </div>
        )}
        <div className="mt-6">
          <input
            type="text"
            name="username"
            value={credentials.username}
            onChange={handleChange}
            placeholder="Username"
            className="w-full px-4 py-2 mt-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
          />
          <input
            type="password"
            name="password"
            value={credentials.password}
            onChange={handleChange}
            placeholder="Password"
            className="w-full px-4 py-2 mt-4 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"
          />
          <button
            onClick={handleLogin}
            className="w-full bg-green-400 text-white font-semibold py-2 px-4 rounded-lg hover:bg-green-500 mt-6 transition duration-300"
          >
            Login
          </button>
        </div>

       
        </div>
        <div className='flex flex-col gap-4 justify-center'>
          <NavLink>Back To Home</NavLink>
          <NavLink>Forgot UserID</NavLink>
          <NavLink>Forgot Password</NavLink>
          <NavLink onClick={onClose} to="/new/official/registration">New User Registration</NavLink>

        </div>
      </div>
    </Box>
  );
};

export default OfficialLogin;
