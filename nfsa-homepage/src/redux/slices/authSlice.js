import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  token: localStorage.getItem('token') ? localStorage.getItem('token') : null,
  role : localStorage.getItem('role') ? (localStorage.getItem("role")) : null 
}

export const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    
    setToken: (state, action) => {
      state.token = action.payload
    },
    setRole : (state , action) =>{
      state.role = action.payload ;
    }
  },
})

// Action creators are generated for each case reducer function
export const { setToken, setRole } = authSlice.actions

export default authSlice.reducer