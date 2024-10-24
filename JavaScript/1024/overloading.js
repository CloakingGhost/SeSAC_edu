function add (x, y){
  return x + y
}

// const value = add(1, 2)
// console.log(value)

const func = add

function add (x, y){
  return x * y
}

const value2 = func(3, 5)
console.log(value2)



// console.log() 의 결과값은 undefined

// 주소값의 개념으로 생각하면
// add 주소의 값이 x + y 에서 x * y로 바꿨기 때문에 
// 실행 되기 전에 x * y로 바뀜
