import React, { useState } from "react";
import style from "./IsLike.module.css";

export default function IsLike() {
  const [isLike, setLike] = useState(false);

  const className = isLike ? style.active : undefined
  
  return (
    <div onClick={toggleLike} className={className}>
      좋아요 {isLike && "취소"}
    </div>
  );

  function toggleLike() {
    return setLike((prev) => !prev);
  }
}
