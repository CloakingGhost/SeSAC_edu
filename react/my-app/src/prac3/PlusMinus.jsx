import { useState } from 'react'

export default function PlusMinus() {
  const [count, setCount] = useState(0)
  return (
    <div>
      <button onClick={() => setCount(prev => prev + 1)}>+</button>
      <button onClick={() => calculator(setCount, "+")}>+</button>
      <div>{count}</div>
      <button onClick={() => setCount(prev => prev - 1)}>-</button>
      <button onClick={() => calculator(setCount, "-")}>-</button>
    </div>
  )
}
function calculator(fn, operator) {
  const foo = new Function('fn', `
    "use strict";
    return () => {
      fn(prev => prev ${operator} 1);
    }
  `);
  return foo(fn)(); // fn을 전달하여 foo()가 즉시 실행하도록 합니다.
}


/* 의견이 궁금합니다.

1. 
조건에 따라
컴포넌트를 받고
컴포넌트의 상태관리를 위해
현위치(부모)에서 state에 변수를 추가해도 되는가?

lazy하게, 즉 필요할 때 state를 추가하여 관리하겠다
{x:0, y:0}

조건에 따라
상태 변수 필요하다면




2. 질문 안해도 될듯
state에 함수를 넣어도 되는가
상태관리에 목적에 맞지 않기 때문에 안해도 될듯
함수의 상태가 변한다???
이상하지 않은가


3. 
컴포넌트 중복 될 때

부모에서 넘겨주는 props을 최하단에 한방에 넘기는 방법없나?

어차피 자식은 넘겨주는거 받아다가 쓰면 되는데 
중간 단계에 있는 컴포넌트가 그 값을 구별하여 
그들의 자식에게 또한 넘겨주는 수고를 해야하나?

props drilling => store
**전역상태관리**


다 있다

*/