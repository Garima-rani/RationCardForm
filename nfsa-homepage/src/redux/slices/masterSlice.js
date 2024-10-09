import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  name : null ,
  data : [] 
}

export const masterSlice = createSlice({
  name: 'master',
  initialState,
  reducers: {
    
    setName: (state, action) => {
      state.name = action.payload
    },
    setData : (state, action) => {
        state.data = action.payload
      },
  },
})

// Action creators are generated for each case reducer function
export const { setData , setName } = masterSlice.actions

export default masterSlice.reducer