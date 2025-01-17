import React, { useState } from 'react';
import authApi from '../api/authApi';
import { useNavigate } from 'react-router-dom';

export default function SignUp() {
  const navigate = useNavigate();

  // 회원가입 폼 데이터
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
  });
  // 로딩 상태
  const [isLoading, setIsLoading] = useState(false);
  // 에러 상태
  const [error, setError] = useState('');

  const handleFormInput = (e) => {
    const { name, value } = e.target;
    // 더티체킹 : 상태 변경 감지

    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError('');
    setIsLoading(true);

    try {
      const signup = await authApi.signup(formData);
      console.log(signup);
      
      alert('회원가입 성공');
      navigate('/'); // 홈, 로그인 페이지, 바로 로그인 됨(자동 로그인)
    } catch (err) {
      setError(err.message);
      console.error(err.response);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div>
      <h2>회원가입</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="username">사용자 이름 : </label>
        <input
          id="username" // 선택 사항
          name="username" // 필수 사항
          required // Validation : UX 개선, 서버로 요청 보내기 전에 유효성 검사
          placeholder="사용자 이름"
          value={formData.username}
          onChange={handleFormInput}
        />

        <div>
          <label htmlFor="email">이메일</label>
          <input
            id="email"
            name="email"
            type="email"
            required
            placeholder="이메일"
            value={formData.email}
            onChange={handleFormInput}
          />
        </div>

        <div>
          <label htmlFor="password">비밀번호</label>
          <input
            id="password"
            name="password"
            type="password"
            required
            placeholder="비밀번호"
            value={formData.password}
            onChange={handleFormInput}
          />
        </div>

        {error && <div>{error}</div>}

        <button type="submit">{isLoading ? '처리중...' : '회원가입'}</button>
      </form>
    </div>
  );
}
