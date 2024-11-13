import React from 'react'

export default function Post({title, children }) {
  return (
    <li>
      <div>
        {title}
      </div>
      <div>
        {children}
      </div>
    </li>
  )
}
