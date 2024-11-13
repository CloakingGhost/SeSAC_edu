import React from 'react'
import { useLocation, useParams } from 'react-router-dom'

export default function PostDetail() {
  const { postId } = useParams()
  const location = useLocation()
  const {title, content} = location.state.post
  console.log(location.state)
  return (
    <div>
      <div>{title}</div>
      <div>{content}</div>
    </div>

  )
}
