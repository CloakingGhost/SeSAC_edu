import React from "react";
import { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import { replace } from "lodash";

export default function PostDetail() {
  const navigate = useNavigate()

  const { postId } = useParams();
  const [post, setPost] = useState() // undefined
  const [loading, setLoding] = useState(true)
  //#region axios로 바꿀거임

  // const posts = useSelector(state => {
  //   console.log(state)
  //   return state.posts
  // })

  //#endregion


  useEffect(() => {
    //#region store에서 안가져오고 axios로 바꿀거임


    // setPost(posts.find((post) => post.id === parseInt(postId)))

    //#endregion
    //#region axios
    
    
    async function fetchGetpost(postId) {
      try {
        const response = await axios.get(`http://localhost:3000/posts/${postId}`)
        const post = response.data
        
        setPost(post)
        
      } catch (error) {
        // navigate('/posts')
        navigate('/not-found')
        // navigate('/not-found', {replace: true})
      } finally {
        setLoding(false)
      }
      
    }
    fetchGetpost(postId)
  }, [postId])

  //#endregion
  if (loading) return <div>로딩중 . . .</div>
  // 콜백함수, 의존성배열(얘가 변해야 됨)

  // console.log(posts)
  // const location = useLocation();

  // const { post } = location.state;
  // const { title, content } = post;

  // 한번 보여주고 useEffect 시작된다
  // useEffect은 랜더링 이후 실행 됨
  // 동기적으로 데이터를 불러올수 있다 아주 잘 보인다
  // 그러나 프론트엔드에서는 데이터를 API로 불러다가 쓰기때문에
  // 처음에는 빈칸을 보여주고 이후 useEffect를 통해 데이터를 새로 입힌다
  // 


  //#region axios 사용하여 Detile 바꾸기


  //#endregion
  return (
    <div>
      <h3>{post?.title}</h3>
      <p>{post?.content}</p>
    </div>
  );
}
