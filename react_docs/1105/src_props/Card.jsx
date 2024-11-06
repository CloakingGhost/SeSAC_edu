import React from "react";

export default function Card({ title = "기본값", content, style }) {
  // const { title, content, width, height } = props;
  // const { title, content, style } = props;
  // console.log(props);
  // const title = "바꾸면";
  // const content = "내용";
  return (
    // <div style={{ width:width, height, backgroundColor: "lightgreen" }}>
    <div style={{ ...style, backgroundColor: "lightgreen" }}>
      <h3>{title}</h3>
      <p>{content}</p>
    </div>
  );
}
