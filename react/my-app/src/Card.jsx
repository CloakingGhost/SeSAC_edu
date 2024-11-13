import React from 'react'

export default function Card({ style, title, children }) {
  return (
    <div style={style}>
      <h3>{title}</h3>
      <div>{children}</div>
    </div>)
}
