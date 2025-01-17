import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import postApi from "../api/postsApi";
import post2Api from "../api/posts2Api";

export default function PostList() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function fetchPosts() {
      try {
        // 정상로직
        // const response = await postApi.getPosts();
        const response = await post2Api.getPosts();
        const data = response.data;
        console.log(data);
        
        setPosts(data.data);
      } catch (err) {
        // 에러 발생
        setError(err.message);
        console.error(err.response);
      } finally {
        // 둘 다의 경우 로딩이 끝
        setLoading(false);
      }
    }

    fetchPosts();
  }, []);

  if (loading) {
    return <div>로딩중</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div>
      <h2>posts</h2>
      <ul>
        {posts.map((post) => {
          const { id, title } = post;
          return (
            <li key={id}>
              {/* 디테일 페이지로 이동 */}
              <Link to={`/posts2/${id}`} state={{ post }}>
                <h3>
                  {id} : {title}
                </h3>
              </Link>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
