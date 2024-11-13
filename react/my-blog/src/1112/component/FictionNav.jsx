import React from 'react'
import { useNavigate } from 'react-router-dom'
const navItems = [
  {
    gerneId: 101,
    gerneKor: "로맨스"
  },
  {
    gerneId: 102,
    gerneKor: "로판"
  },
  {
    gerneId: 103,
    gerneKor: "현판"
  },
  {
    gerneId: 104,
    gerneKor: "판타지"
  },
  {
    gerneId: 105,
    gerneKor: "무협"
  },
]
export default function FictionNav() {
  const navigate = useNavigate()
  return (
    <nav>
      <ul>
        <li>전체</li>
        {navItems.map(({ gerneId, gerneKor }) => {
          return (
            <li onClick={() => navigate(`/fiction/${gerneId}`)}>
              {gerneKor}
            </li>
          )
        })}
      </ul>
    </nav>
  )
}
