import Post from './Post'
import posts from '../assets/posts.json'
import { Link, useNavigate } from 'react-router-dom'


export default function PostList() {
  const navigate = useNavigate();
  return (
    <div>
      <h3>Posts</h3>
      <ul>
        {posts.map((post) => {
          const { id, title, content } = post
          return (
            <li key={id}>
              <Link to={`/posts/${id}`} state={{ post }}>
                <div>{title}</div>
              </Link>
              <h4 onClick={() => {
                navigate(`/posts/${id}`, {
                  state: { post }
                })
              }}>
                {title}
              </h4>
            </li>
          )
        })}
      </ul>
    </div>
  )
}
