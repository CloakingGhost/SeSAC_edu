import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  token: localStorage.getItem('token'),
  isLoggedIn: !!localStorage.getItem('token'),
  user: {
    name: 'anonimoususer',
  },
};
/*

*/

const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    // setter의 동작을 제한

    // 스토어 토큰 넣기
    // 로컬 스토리지 토큰 넣기
    login: (state, action) => {
      state.token = action.payload; // payload의 응답값이 들어온다(token)
      state.isLoggedIn = true;
      localStorage.setItem('token', action.payload);
    },
    logout: (state, action) => {
      state.token = null;
      state.isLoggedIn = false;
      localStorage.removeItem('token');
    },
  },
});

export const { login, logout } = authSlice.actions;
export default authSlice.reducer;
