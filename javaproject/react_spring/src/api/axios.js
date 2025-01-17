import axios from 'axios';
import store from '../store/store';

const api = axios.create({
  baseURL: import.meta.env.VITE_APP_API_URL,
});

// interceptor
// 요청 || 응답 가로채기
// 요청에 보내지면 JWT를 넣는다
// 응답이 클라이언트에 도착 직전에 에러(Exception)를 찾아 처리할 수 있음
api.interceptors.request.use((config) => {
  const token = store.getState().auth.token;
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;
