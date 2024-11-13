import React from "react";

export default function Button({ backgroundColor, color = "white", text }) {
  // const backgroundColor = "blue";
  // const text = "확인";
  return <button style={{ backgroundColor, color }}>{text}</button>;
}
