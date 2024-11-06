import React from "react";
import Button from "./Button";
// 버튼은 버튼인데, 색이 빨간색인 버튼.
// 대신, 텍스트는 변경 가능.
export default function CancleButton(props) {
  const { text, children } = props;

  return (
    <div>
      <Button backgroundColor="red" text={children}></Button>
    </div>
  );
}
