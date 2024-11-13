import React from 'react'
import { useNavigate, useSearchParams } from 'react-router-dom'
import { Outlet } from 'react-router-dom'
import WebtoonNav from "../component/WebtoonNav";
const days = [
  {
    day: "mon",
    dayKor: "월"
  },
  {
    day: "tue",
    dayKor: "화"
  },
  {
    day: "wed",
    dayKor: "수"
  },
  {
    day: "thu",
    dayKor: "목"
  },
  {
    day: "fir",
    dayKor: "금"
  },
  {
    day: "sat",
    dayKor: "토"
  },
  {
    day: "sun",
    dayKor: "일"
  }
]
export default function Webtoon() {
  const navigate = useNavigate()
  return (
    <div>
      <WebtoonNav></WebtoonNav>

      <Outlet ></Outlet>
    </div>
  )
}

