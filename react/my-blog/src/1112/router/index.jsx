import { createBrowserRouter, useParams } from "react-router-dom";
import RootLayout from "../../RootLayout";
import Home from "../pages/Home";
import Webtoon from "../pages/Webtoon";
import Fiction from "../pages/Fiction";
import WebtoonDetail from "../component/WebtoonDetail";
import FictionDeteil from "../component/FictionDeteil";
import WebtoonNav from "../component/WebtoonNav";
import FictionNav from "../component/FictionNav";
function WebtoonWrapper() {
  const { day } = useParams();
  return day ? <WebtoonDetail /> : <div>요일별 모든 웹툰 : 비동기 통신으로 가져옴</div>;
}
const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    children: [
      {
        index: true,
        element: <Home />
      },
      {
        path: "/webtoon",
        element: <Webtoon />,
        children: [
          {
            path: ":day?",
            element: <WebtoonWrapper />,
          },
        ]
      },
      {
        path: "/fiction",
        element: <Fiction />,
        children: [
          {
            index: true,
            element: <div>다양한 장르의 소설 : 비동기 통신으로 가져옴</div>
          },
          {
            path: ":genre",
            element: <FictionDeteil />,
            // loader
          }
        ],
      },

    ]
  }
])

export default router;