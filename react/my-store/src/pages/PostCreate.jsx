import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addPost } from '../store/slices/postsSlice';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function PostCreate() {

  // reducer triger, execute setter
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    title: null,
    content: null,
  });
  const { isAuthenticated } = useSelector(state => state.auth)

  //랜더링된 이후 실행
  useEffect(() => {
    if (!isAuthenticated) {
      navigate("/")
    }
  }, [isAuthenticated])
  // alert(1)
  // 이건 안됨
  if (!isAuthenticated) {
    return <div>로그인 하셈</div>
  }

  return (
    <>
      <h3>PostCreate</h3>
      <form
        onSubmit={(e) => {
          e.preventDefault();
          // dispatch(addPost({ ...formData, id })); // axios로 바꿈
          async function fetchCreatePost(data) {
            console.log("data : ")
            console.log(data)

            const response = await axios.post('http://localhost:3000/posts', data)
            const result = response.data
            console.log(result)

          }
          // navigate(`/posts/${id}`);

          fetchCreatePost(formData)
        }}

        onChange={(e) => {
          setFormData((prev) => {
            return {
              ...prev,
              [e.target.name]: e.target.value,
            };
          });
          console.log(formData);
        }}
      >
        <label htmlFor="title">제목 : </label>
        <input type="text" name="title" id="title" />
        <label htmlFor="content">내용 : </label>
        <textarea name="content" id="content"></textarea>
        <button type="submit">제출</button>
      </form>
    </>
  );
}
