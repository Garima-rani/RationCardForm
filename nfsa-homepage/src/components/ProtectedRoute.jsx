
import useAuth from '../hook/useAuth'; // Ensure this path is correct
import React from 'react'
import { useSelector } from 'react-redux';
// import { useSelector } from 'react-redux'
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({children}) => {

    const {token} = useSelector((state) => state.auth);
    // const token = "Gfdfds/3234dscxxvdsdf3sdfs9sdF=+" ; 
    if(token !== null)
        return children
    else
        return <Navigate to="/official-login" />

}

export default ProtectedRoute
