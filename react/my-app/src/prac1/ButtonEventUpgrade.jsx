import React from 'react'

export default function ButtonEventUpgrade({ onClick, children, style }) {
  return (
    <button onDoubleClick={onClick} style={style}>{children}</button>
  )
}
