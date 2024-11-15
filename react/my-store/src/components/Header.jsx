import React from "react";
import { Link } from "react-router-dom";
import Login from "./Login";
import { useSelector } from "react-redux";

export default function Header() {
  const { isAuthenticated } = useSelector(state => state.auth)
  return (
    <header>
      <ul>
        <li>
          <Login auth={isAuthenticated} />
        </li>
        <li>
          <Link to="/">Home으로</Link>
        </li>
        <li>
          <Link to="/posts">게시글로</Link>
        </li>

        {isAuthenticated &&
          <li>
            <Link to="/posts/create" >
              게시글 생성
            </Link>
          </li>
        }
      </ul>
    </header>
  );
}
