import { configureStore } from '@reduxjs/toolkit'
import authReducer from './slices/authSlice'
import masterReducer from "./slices/masterSlice"

export const store = configureStore({
  reducer: { auth : authReducer , master : masterReducer },
})