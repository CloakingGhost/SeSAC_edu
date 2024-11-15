import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import PostList from "../pages/PostList";
import Hello from "../pages/Hello";
import RootLayout from "../RootLayout";
import PostDetail from "../pages/PostDetail";
import NotFound from "../pages/NotFound";
import PostCreate from "../pages/PostCreate";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    errorElement: <NotFound />,
    children: [
      {
        index: true,
        element: <Home />,
      },
      {
        path: "/posts",
        element: <PostList />,
      },
      {
        path: "/posts/create",
        element: <PostCreate />,
      },
      {
        // :postId 아무거나 다 올 수 있다 
        // 구버전의 경우 순서가 중요하다
        path: "/posts/:postId",
        element: <PostDetail />,
      },
    ],
  },
  {
    path: '/not-found',
    element: <NotFound></NotFound>
  }
]);

export default router;
