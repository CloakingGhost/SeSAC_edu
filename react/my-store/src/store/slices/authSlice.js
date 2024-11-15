import { createSlice } from '@reduxjs/toolkit';
// import { useState } from 'react';

const initialState = { isAuthenticated: false };

const reducers = {
  logout: (state) => {
    state.isAuthenticated = false;
  },
  login: (state) => {
    state.isAuthenticated = true;
  },
};
const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers,
});
// const lst = [1, 2, 3, 4];
// const [value, setValue] = useState(initialState);
export const { login, logout } = authSlice.actions;
export default authSlice.reducer;
