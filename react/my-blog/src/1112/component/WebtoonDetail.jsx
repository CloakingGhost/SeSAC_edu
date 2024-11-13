import React from 'react'
import { useParams } from 'react-router-dom'

export default function WebtoonDetail() {
  const {day} = useParams()
  return (
    getItem(day)
  )
}


function getItem(key) {
  if(!key) return <div>요일별 모든 웹툰 : 비동기 통신으로 가져옴</div>
  return <div>{key}웹툰: 비동기 통신으로 가져옴</div>
}