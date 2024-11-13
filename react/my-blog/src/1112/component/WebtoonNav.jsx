import React from 'react'
import { useNavigate } from 'react-router-dom'
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
export default function WebtoonNav() {
  const navigate = useNavigate()
  return (
    <nav>
      <ul>
        <li onClick={() => navigate('/webtoon')}>전체</li>
        {days.map(
          ({ day, dayKor }) => {
            return (<li key={day} onClick={() => navigate(`/webtoon/${day}`)}>{dayKor}</li>)
          }
        )}
      </ul>
    </nav>
  )
}
