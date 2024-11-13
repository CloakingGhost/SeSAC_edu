import React from 'react'
import { Outlet } from 'react-router-dom'
import Header from './1112/component/Header'
import Footer from './1112/component/Footer'

export default function RootLayout() {
  return (
    <>
      <Header></Header>
      <Outlet></Outlet>
      <Footer></Footer>
    </>
  )
}