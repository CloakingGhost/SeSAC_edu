import React from 'react'
const users = [
  { id: 1, name: '김철수', age: 25, hobby: '독서' },
  { id: 2, name: '이영희', age: 28, hobby: '요리' },
  { id: 3, name: '박민수', age: 23, hobby: '게임' }
];
export default function User() {
  return (
    <div>
      <ul>
        {users.map(el =>
          <li key={el.id}>
            <div>{el.id}</div>
            <div>{el.name}</div>
            <div>{el.age}</div>
            <div>{el.hobby}</div>
          </li>)}
      </ul>
    </div>
  )
}
