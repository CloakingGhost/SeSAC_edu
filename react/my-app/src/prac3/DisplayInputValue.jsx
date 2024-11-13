import React, { useState } from "react";
// https://1yoouoo.tistory.com/16
export default function DisplayInputValue() {
  const [text, setText] = useState("");
  return (
    <div>
      <input
        type="text"
        onInput={(e) => {
          setText((prev) => {
            prev = e.target.value
            return prev;
          });
        }}
      />
      <div>{text}</div>
    </div>
  );
}
