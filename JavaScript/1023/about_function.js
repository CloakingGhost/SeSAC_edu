// 정의 된 함수에 주어지는 변수: 매개변수 파라미터

// 함수호출을 위해 사용하는 변수: 인자 아규먼트

// 1. 2를 곱하는 함수를 만들어보자
// 2. 소수를 판별하는 함수를 만들어보자
// 3. 구구단 중 n단을 return하는 함수를 만들어보자.


// 1. 일단 함수의 틀을 만든다.

// 2. 하고 싶은 일을 서술한다.

// 2-1. 어떤 값을 넣어야 이 함수를 실행 시킬 수 있을까?
// 2-1. 함수를 실행 시키려면 어떤 값이 필요할까?

// 2-2. 이 함수는 어떤걸 return(결과값)해야 될까?


//// 1. 2를 곱하는 함수를 만들어보자








function makeDouble(num) {
  return num * 2;
}

function isPrime(num){

  if (num <= 1) return false
  if (num === 2 || num === 3) return true
  if (num % 2 === 0 || num % 3 === 0) return false

  for(let i = 5; i <= Math.sqrt(num); i += 6) {
    if(num % i === 0 || num % (i + 2) === 0){
      return false;
    }
  }

  return true
}

function makeMultiplcationTable(num){
  const gugudan = new Array()
  for(let i = 1; i <= 9; i++){
    arr.push(i * num)
  }
  return gugudan;
}


let result = isPrime(3)
console.log()










let number = 0
console.log(number)

number = 123
console.log(number)

const something = 'abcs' 
console.log(something)

// something = 'bbbb'
console.log(something)


// 값이 변하지 않는 상황 const
// 변하면 let

// 일단 무조건 const

// 에러 let



// for(초기식; 조건식; 증감식) 
for(let i = 0; i < 10; i++) {
  // 엄청난 작업, 코드 만줄짜리


}


function sum(...nums){
  console.log(nums)
  console.log(arguments.length)
  arguments[0] = 9999
  console.log(arguments)
}



sum(1,2,3,4)
sum([1,2,3,4])