import React from 'react'
import { Outlet } from 'react-router-dom'
import Header from './component/Header'
import Footer from './component/Footer'

export default function RootLayout() {
  return (
    <>
      {/* <header>
        <ul>
          <li>
            <Link to="/">Home으로</Link>
          </li>
          <li>
            <Link to="/posts">게시글로</Link>
          </li>
        </ul>
      </header> */}
      <Header></Header>
      <Outlet></Outlet>
      <Footer></Footer>
    </>
  )
}
