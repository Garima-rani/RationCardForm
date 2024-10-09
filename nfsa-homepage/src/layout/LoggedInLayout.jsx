import React, { useState } from 'react'
import { NavLink, Outlet, useNavigate } from 'react-router-dom'
import SettingsSuggestIcon from '@mui/icons-material/SettingsSuggest';
import MenuIcon from '@mui/icons-material/Menu';
import CustomAccordion from '../components/common/CustomAccordion';
import { useDispatch } from 'react-redux';
import{ setToken , setRole} from "../redux/slices/authSlice"


function LoggedInLayout() {
    const [sidebarOpen , setSidebarOpen] = useState(true)
    const dispatch = useDispatch() ; 
    const navigate = useNavigate() ;

    const logoutHandler = (e)=>{
        e.preventDefault() ;
        dispatch(setToken(null)) ; 
        dispatch(setRole(null)) ; 
        localStorage.removeItem('role');
        
        localStorage.removeItem('token');
        navigate('/');
      }

    const toggleSidebar = ()=>{
        setSidebarOpen(!sidebarOpen)
    }
    
  return (
    <div className='w-screen h-full  flex flex-col bg-black'>
        <div className='flex flex-col md:flex-row w-full  bg-[#3C8DBC] flex justify-center'>
            <div className='flex   w-fit  text-white'>
            <img className='h-[30px] md:h-[60px] w-fit  ' src="/nfsa-logo.png" />
            <p className='text-xs w-fit '>National Food Security Dashboard</p>
            </div>

                <div className='w-full h-full flex items-center text-white'>
            <div className='w-full h-full rounded-md  bg-[#3C8DBC] py-3 text-white flex justify-between items-center px-5'>
            <div className='flex gap-2 items-center gap-3 '>
            <MenuIcon onClick={toggleSidebar} className='cursor-pointer' />

            <h2 className='font-semibold text-lg max-md:hidden'>Department Of Food and Public Distribution</h2>
            </div>
            <div className='flex gap-5 '>
                <NavLink>Go To Form</NavLink>
                <p className='cursor-pointer'>A</p>
                <p className='cursor-pointer bg-'>Garima Rani</p>
                <SettingsSuggestIcon onClick={logoutHandler}  className='cursor-pointer'/>
            </div>
        </div>
        </div>
        </div>
        <div className='flex h-full bg-white h-full  mb-2 '>
            {sidebarOpen && <aside className='w-[230px] h-full bg-gray-600'>
                    <CustomAccordion />
            </aside>}
            {/* Anmol */}
            <Outlet />
        </div>
       
        <footer className='h-[40px] text-white flex justify-between items-center  text-sm max-md:flex-col gap-2  px-10 '>
            <p>Copyright &copy 2023-2024 <span>National Informatics Center</span>.<span>All rights reserved</span></p>
            <p>Version 2.2</p>
        </footer>
    </div>
  )
}

export default LoggedInLayout