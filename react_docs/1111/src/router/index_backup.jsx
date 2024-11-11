import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home.jsx";
import PostList from "../pages/PostList.jsx";
import Hello from "../pages/Hello.jsx";
import RootLayout from "../RootLayout.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />
  },
  {
    path: "/posts",
    element: <PostList />,
  },
  {
    path: "/hello",
    element: <Hello />,
  },
]);

export default router;
