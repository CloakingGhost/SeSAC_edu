import React, { useState } from "react";

export default function Counter() {
/* 일반 num의 사이즈를 키우면 출력과 연결되지 않음
 * 값은 바뀌지만 화면은 변하지 않음
 * 값은 변하지만 과도한 랜더링의 방지하기 위함
 */
  const [num, setNum] = useState(0);
  return (
    <div>
      <div>{num}</div>
      <button onClick={() => setNum(num + 1)}>클릭</button>
      <button onClick={() => console.log(num)}>출력</button>
    </div>
  );
}
