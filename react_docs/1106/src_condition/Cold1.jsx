import React from "react";

export default function Cold1() {
  const cold = false; // false
  let result;
  if (cold) {
    result = <div>감기 걸림 ㅠㅠ</div>;
  } else {
    result = <div>감기 안거림!</div>;
  }

  return result;
}
