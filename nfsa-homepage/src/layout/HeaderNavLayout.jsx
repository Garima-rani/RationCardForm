import React from 'react'
import Header from '../components/Header'
import Navbar from '../components/Navbar'
import { Outlet } from 'react-router-dom'

function HeaderNavLayout() {
  return (
    <div>
        <Header />
        <Navbar />
        <Outlet />

    </div>
  )
}

export default HeaderNavLayout