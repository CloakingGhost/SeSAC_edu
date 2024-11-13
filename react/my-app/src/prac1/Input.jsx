import React from "react";

export default function Input() {
  return (
    <>
      <input type="text" onChange={handleChange} onInput={handleInput} />
    </>
  );
}
const handleChange = (e) => {
  console.log("i", e.target.value);
};
const handleInput = (e) => {
  console.log("c", e.target.value);
};
