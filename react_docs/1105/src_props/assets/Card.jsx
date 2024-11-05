import React from "react";
const border = "1px solid black";

export default function Card({ width, height, title, content }) {
  return (
    <div style={{ width, height, border }}>
      <div>{title}</div>
      <div>{content}</div>
    </div>
  );
}
