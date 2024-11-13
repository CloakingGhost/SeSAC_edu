import React from "react";

export default function Cold1() {
  const cold = false; // false
  // let result;
  // if (cold) {
  //   result = <div>감기 걸림 ㅠㅠ</div>;
  // } else {
  //   result = <div>감기 안거림!</div>;
  // }
  // return result
  const value = true ? "true인 경우" : "false인 경우";

  return (
    <>
      <div>{cold ? "감기걸림" : "감기안걸림"}</div>
      {cold ? <div>감기걸림</div> : <div>감기 안걸림</div>}
    </>
  );
}
