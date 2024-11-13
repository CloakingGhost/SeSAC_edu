import React from "react";
import { RouterProvider} from "react-router-dom";
import router from "./1112/router/index.jsx";

export default function App() {
  return (
    <>
      <RouterProvider router={router}></RouterProvider>
    </>
  );
}
