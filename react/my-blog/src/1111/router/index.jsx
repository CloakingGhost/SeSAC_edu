import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import PostList from "../pages/PostList";
import Hello from "../pages/Hello";
import RootLayout from "../RootLayout";
import PostDetail from "../pages/PostDetail";
import NotFound from "../pages/NotFound";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    children: [
      // Outlet 자리에 들어감
      {
        index: true, // 부모의 path를 그대로 가져옴
        // path: '',
        element: <Home/>
      },
      {
        path: '/posts',
        element: <PostList/>,
      },
      {
        // 동적라우팅
        path: '/posts/:postId',
        element: <PostDetail/>,
        // errorElement: <NotFound/>
      },
    ]
  }
]);

export default router;
