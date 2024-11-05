import React from 'react'

export default function Button({ content, backgroundColor, color }) {
  return (
    <button style={{backgroundColor, color}}>{content}</button>
  )
}
