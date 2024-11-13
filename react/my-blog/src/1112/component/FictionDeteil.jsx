import React from 'react'
import { useParams } from 'react-router-dom'


export default function FictionDeteil() {
  const { genre } = useParams()
  return (
    getItem(genre)
  )
}
function getItem(key) {
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
  // 동적 라우터 변수 타입 string
  const intKey = Number(key)
  for( const {gerneId, gerneKor} of navItems){
    if(gerneId === intKey){
      return <div>{gerneKor} : 비동기 통신으로 가져옴</div>
    }
  }

}