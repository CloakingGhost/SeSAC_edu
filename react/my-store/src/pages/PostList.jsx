import React, { useEffect, useState } from "react";
// import { useSelector } from "react-redux"; // axios로 바꿀거임
import { Link, useNavigate } from "react-router-dom";
import axios from 'axios'

export default function PostList() {
  const navigate = useNavigate();
  const [posts, setPosts] = useState([])
  const [isLogding, setLoding] = useState(true)
  const [error, setError] = useState(null)

  // const posts = useSelector((state) => state.posts)  // axios로 바꿀거임

  //#region store 사용 함

  /* 
  store 사용해서 이제 안 쓸거임
  const [posts, setPosts] = useState([
    {
      id: 1,
      title: "첫 번째 프로젝트",
      content:
      "첫 프로젝트에서 간단한 Todo 앱을 만들었습니다. UI 구성과 상태 관리의 중요성을 배웠습니다.",
      },
      {
        id: 2,
        title: "리액트와 함께한 성장",
        content:
        "리액트로 컴포넌트 기반 개발을 익히고, 재사용성을 높이는 방법을 이해하게 되었습니다.",
        },
        {
          id: 3,
          title: "팀 프로젝트 경험",
          content:
          "팀원들과 협업하여 일정 관리 앱을 개발했습니다. Git을 활용한 버전 관리와 코드 리뷰의 중요성을 체감했습니다.",
          },
          ]); */

  //#endregion

  //#region axios로 post 가져오기
  useEffect(() => {
    async function fetchGetPosts() {
      try {
        const response = await axios.get('http://localhost:3000/posts')
        const posts = response.data
        setLoding(false)
        setPosts(posts)
      } catch (er) {
        setError(er)
        console.log(error.name)
      }
    }
    fetchGetPosts()


  }, [isLogding])
  if (isLogding) {
    return <div>로딩중</div>
  }
  //#endregion
  return (
    <div>
      <h2>posts</h2>
      <ul>
        {posts.map((post) => {
          const { id, title, content } = post;
          return (
            <li key={id}>
              <Link to={`/posts/${id}`} state={{ post }}>
                <h3>{title}</h3>
              </Link>
              <h3
                onClick={() => {
                  // 이동을 하고 싶다
                  navigate(`/posts/${id}`);
                }}
              >
                {title}
              </h3>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
