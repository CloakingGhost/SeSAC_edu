import React from "react";
import { RouterProvider } from "react-router-dom";
import router from "./router";

import { Provider } from "react-redux";
import store from "./store/store";

export default function App() {
  return (
    // 모든 요청과 새로고침에 대해
    // 사용자가 진입을 했을 때 토큰은 검증해야함
    // Provider들 안쪽에 로직을 구현해야함
    // 현 프로젝트는 다른 경로가 없으므로 편의상
    // RootLayout.jsx에 구현하는 것으로 합의함
    <>
      <Provider store={store}>
        <RouterProvider router={router}></RouterProvider>
      </Provider>
    </>
  );
}
