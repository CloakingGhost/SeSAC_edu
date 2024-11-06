import React from "react";

export default function Cold3() {
  const cold = false;

  // 감기에 걸렸을 때는 보여주고
  // 안걸렸을 때는 안보여줄래.
  return <div>{cold && "감기걸림"}</div>;
}
