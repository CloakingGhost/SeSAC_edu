import React from "react";

export default function Article({ title, content }) {
  // const title = "제목";
  // const content = "내용";
  // const { title, content } = props;
  return (
    <>
      <h1>{title}</h1>
      <p>{content}</p>
    </>
  );
}

function add(x, y){
  return x + y
}

add(2, 3)