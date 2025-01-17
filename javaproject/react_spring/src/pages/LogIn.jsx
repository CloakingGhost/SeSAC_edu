import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import authApi from "../api/authApi";
import { useDispatch } from "react-redux";
import { login } from "../store/slices/authSlice";

export default function Login() {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const [error, setError] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useNavigate();
  const dispatch = useDispatch();

  // 커스텀 훅으로 따로 뺄 수 있다
  const handleFormInput = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");
    setIsLoading(true);

    try {
      const response = await authApi.login(formData);
      const data = response.data;
      console.log(data);
      
      const { token } = data.data;
      console.log(token);
      dispatch(login(token)); // 전역 상태관리인 스토어를 사용, 기능을 전역으로 사용할 수 있음
      navigate("/");
    } catch (err) {
      console.error(err);
      setError(err.message || "로그인 중 오류가 발생했습니다.");
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
          id="username"
          name="username"
          required
          placeholder="사용자 이름"
          value={formData.username}
          onChange={handleFormInput}
        />

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

        <button type="submit">{isLoading ? "처리중..." : "로그인"}</button>
      </form>
    </div>
  );
}
