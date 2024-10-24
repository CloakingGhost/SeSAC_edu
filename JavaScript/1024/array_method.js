const numbers = [1, 2, 3, 4];

// for of의 기능을 함
// 반복문을 내장 시킴
numbers.forEach((num) => {
  console.log(num); // 1, 2, 3, 4
});


// 배열을 리턴
const doubled = numbers.map((num) => {
  console.log(num);
  return num * 2;
});

console.log(doubled); // [2, 4, 6, 8]

// 문제 1
// [1, 2, 3, 4] 만들기
let strNumbers = ['1', '2', '3', '4']

let result = strNumbers.map((str, idx, strNumbers) => {
  console.log(`${idx}, ${strNumbers[idx]}`)
  return parseInt(str)
})
console.log(result)

// 문제 2
// 최소값 구하기
let nums = [11, 3, 5, 8, 9, 10, 2, 13, 4, 12, 1, 6, 7, -3]
// 초기값 안넣어주면 '배열[0]' 들어감
result = nums.reduce((acc, cur) => cur < acc ? cur : acc)
console.log(result)

// 문제 3
// 소수만 담은 배열 구하기
function isPrime(num){
  if (num <= 1) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true
}


result = nums.filter(num => isPrime(num)).sort((a, b) => a - b)
console.log(result)

