import React, { useEffect } from "react";
import { Outlet } from "react-router-dom";
import Header from "./components/Header";
import { useDispatch } from "react-redux";
import authApi from "./api/authApi";
import { logout } from "./store/slices/authSlice";
export default function RootLayout() {
  const dispatch = useDispatch();


  // 리프레시 토큰까지 할 수있음
  // 1. 만료임?
  // 2. 다시 받아오셈
  // 3. 받아옴?
  // 4. 토큰 검증 해봄
  // 5. OK 로그인 해줌
  // 6. naviagte("/")
  useEffect(() => {
    const verifyToken = async () => {
      try {
        await authApi.verify();
      } catch (err) {
        dispatch(logout());
      }
    };
    verifyToken();
  }, []);

  return (
    <>
      <Header></Header>
      <Outlet></Outlet>
      <footer></footer>
    </>
  );
}
