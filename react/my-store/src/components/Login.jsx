import React from 'react';
import { useDispatch } from 'react-redux';
import { login, logout } from '../store/slices/authSlice';
import { useNavigate } from 'react-router-dom';

export default function Login({ auth }) {
  const navigate = useNavigate();

  // console.log(isLogout);

  const dispatch = useDispatch();
  const execute = auth ? logout : login;
  return (
    <button
      onClick={() => {
        dispatch(execute());
        if (auth) {
          navigate('/');
        }
      }}
    >
      로그{!auth ? '인' : '아웃'}
    </button>
  );
}
