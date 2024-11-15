import React from 'react';
import { Navigate, redirect, useParams } from 'react-router-dom';
const days = ['mon', 'tue', 'wed', 'thu', 'fir', 'sat', 'sun'];
export default function WebtoonDetail() {
  const { day } = useParams();
  return getItem(day);
}

function getItem(key) {
  if (!days.includes(key)) {
    <Navigate to={'/webtoon'} replace={false}/>
  }
  return <div>{key}웹툰: 비동기 통신으로 가져옴</div>;
}
