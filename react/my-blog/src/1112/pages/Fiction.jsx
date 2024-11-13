import React from 'react'
import { useNavigate } from 'react-router-dom'
import FictionNav from '../component/FictionNav'
import { Outlet } from 'react-router-dom'

export default function Fiction() {
  const navigate = useNavigate()
  return (
    <div>
      <FictionNav></FictionNav>
      {getItem()}
      <Outlet></Outlet>
    </div>
  )
}

function getItem() {
  return <div>모든 소설 목록 : 비동기 통신으로 가져옴</div>
}