import React from 'react'

export default function ButtonEvent() {
  return (
    <button onDoubleClick={handleClicked}>U can't Touch This</button>
  )
}
function handleClicked() {
  alert("You Clicked ME!")
}