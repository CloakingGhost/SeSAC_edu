import React from 'react'
import { Link } from 'react-router-dom'

export default function Header() {
  return (
    <ul>
      <li><Link to="/webtoon">웹툰</Link></li>
      <li><Link to="/fiction">소설</Link></li>
    </ul>
  )
}
