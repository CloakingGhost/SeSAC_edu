import React, { useState } from 'react'

export default function ChangeBoxColor() {
  const [backgroundColor, setBackgroundColor] = useState("#ffffff")
  return (
    <div>
      <div style={{ border: "1px solid black", width: 200, height: 200, backgroundColor }}></div>
      <input type="color" onChange={(e) => setBackgroundColor(prev => {
        prev = e.target.value
        return prev
      })} />
    </div>
  )
}
