const number_1 = 5;
console.log(number_1 < 10 ? `${number_1}\nnumber_1은 10보다 작다.` : number_1)

const num1 = 5
console.log(num1)
console.log(num1 % 2 == 0 ? '짝수' : '홀수')

const variable = 333
console.log(variable)

if (variable < 10) {
  console.log('number_1은 10보다 작다.')
} else {
  console.log('number_1은 10보다 크다.')
}

const score = 123123
console.log(score >= 60 ? 'pass' : 'fail')


const number1 = 10
if (typeof number1 !== 'number') {
  console.log('Hello World\n숫자가 아니다.')
}
else if (number1 < 10) {
  console.log('number1은 10보다 작다')
} else if (number1 === 10) {
  console.log('number1은 10이다')
} else if (number1 > 10) {
  console.log('number1은 10보다 크다')
}



const n1 = 0;

console.log(n1)
if (n1 === 0) {
  console.log('영')
} else if (n1 % 2 === 0) {
  console.log('짝수')
} else if (n1 % 2 === 1) {
  console.log('홀수')
} else {
  console.log('양의 정수만 작성하시오')
}

const username = 'sesac'
const password = 'sesac123'

if(username ==='sesac' && password === 'sesac1234'){
  console.log('로그인 성공')
} else{
  console.log('로그인 실패')
}

const n_1 = 44
const n_2 = 2
console.log(Math.max(n_1, n_2))
if(n_1 === n_2) console.log('the same number')



const n_3 = 3
console.log(n_3)
if(n_3 % 2 === 0 && n_3 % 3 === 0){
  console.log("6의 배수")
} else if(n_3 % 2 === 0) {
  console.log("2의 배수")
  
}else if(n_3 % 3 === 0) {
  console.log("3의 배수")

} else {
  console.log("2의 배수도 아니고, 3의 배수도 아니다.")
}
