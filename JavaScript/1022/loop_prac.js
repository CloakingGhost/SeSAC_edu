for (let i = 3; i <= 40; i += 3) {
  console.log(i);
}
let cnt = 0;
for (let i = 7; i <= 100; i += 7) {
  cnt++;
}
console.log(cnt)
console.log()

const arr = [1, 2, 4, 3, 3, 5, 5, 6, 9, 7]
const notTargets = [1, 4, 5, 7]
// 인덱스 접근이 좋다
// 값 확인 용도로는 안좋다
// for (const num of arr) {
// let flag = false;
//   for(const notTarget of notTargets){
//     if(num === notTarget) {
//       flag = true
//       break;
//     }
//   }
//   if(!flag) console.log(num)
// }

// 해시로 되어 있어 존재 여부를 찾을 때 아주 빠르다.
// O(1)
// 값을 찾을 수는 없다.
// 꺼낼 때는 랜덤으로 가능하다
const notTargetsSet = new Set(notTargets)
for (const num of arr) {
  if (notTargetsSet.has(num)) {
    continue
  }
  console.log(num)
}
const answer = []
for (let i = 1; i <= 9; i++) {
  if (i ** 2 >= 10 && i ** 2 <= 50) {
    answer.push(i);
  }
}
console.log(answer)

const inputNum1 = 3, inputNum2 = 6;
let sum = 0;

if (inputNum1 > inputNum2) [inputNum1, inputNum2] = [inputNum2, inputNum1]

for (let start = inputNum1; start <= inputNum2; start++) {
  sum += start;
}
console.log(sum)
console.log(Math.floor(((inputNum2 - inputNum1 + 1) * (inputNum1 + inputNum2)) / 2))

let number = 1
while (number <= 30) {
  // 2로 나누어 떨어지는 것을 제외
  // 2로 나누어 떨어지는 것은 넘겨
  if (!(number % 2)) { number++; continue }

  if (!(number % 3)) { number++; continue }
  console.log(number)
  number++
}
number = 1
while (number <= 30) {
  if (!(number % 2) || !(number % 3)) { number++; continue }
  console.log(number)
  number++;
}
number = 1
while (number <= 30) {
  if (number % 2 && number % 3)
    console.log(number)
  number++;

}

console.log()
// 소수?
// 1과 자기 자신으로만 나누어 떨어지는 수
// 1, 자기 자신 빼고는 나머지 싹다로는 나누어 떨어지지 않는 수

// 소수가 아닌 수?
// 1과 자기 자신 이외에 어떠한 수로 나누어 떨어지는 수
// 어떠한 수들로 나누어 보자. 나머지가 존재하지 않으면 소수가 아님

// 기본값으로 주어진 수를 소수라 하자
// 그런데 2~ n-1 중에 하나라도 나누어 떨어지면 소수가 아님
number = 97979
let flag = true
if (number <= 1) flag = false
// if(number === 2 || number === 3) flag = true
if (number % 2 == 0 || number % 3 == 0) flag = false
for (let i = 5; i <= Math.floor(Math.sqrt(number)); i += 6) {
  if (number % i === 0 || number % (i + 2) === 0) {
    flag = false
    break
  }
}
console.log(`number is prime? : ${flag}`)

// class version
// class Person {
//   constructor(name, age, gender) {
//     this.name = name;
//     this.age = age;
//     this.gender = gender;
//   }
// }
// // 3명 선언
// const p1 = new Person('jun', 15, 'M')
// const p2 = new Person('ken', 26, 'F')
// const p3 = new Person('alex', 37, null)

// // 배열에 담음
// const people = []
// people.push(p1, p2, p3)
// // 확인
// console.log(people)

// // 'alex' 찾기
// for (const p of people) {
//   if (p.name === 'alex') {
//     console.log(p)
//     break
//   }
// }

// // 이름으로 찾기위해 Map
// const peopleMap = new Map()
// for (const p of people) {
//   peopleMap.set(p.name, p)

// }

// // 이름으로 값 확인
// console.log(peopleMap.get('jun'))


//Object version
const arrPeople = [
  {
    name: 'jun',
    age: 15,
    gender: "M"
  },
  {
    name: 'ken',
    age: 26,
    gender: "F"
  },
  {
    name: 'alex',
    age: 37,
    gender: null
  }
]
for(const person of arrPeople){
  for(const key in person){
      console.log(key, person[key])
  }
  
}

for(const person of arrPeople){
  if(person.name === 'alex'){
    console.log(person)
    console.log(person.age)
  }
}

const objectPeople = {}

for(const person of arrPeople){
  objectPeople[person.name] = person
}

