const arr1 = [1, 2, 3, 4, 5];
// 를 활용하여
const newArr1 = [1, 4, 9, 16, 25];
// 를 만들어보자.
let answer = arr1.map((n) => n ** 2);
console.log(answer);

///////////////////////////////////////////////////////////////////////////////////////

const arr2 = ['1', '2', '3', '4', '5'];
// 를 활용하여
const newArr2 = [1, 2, 3, 4, 5];
// 를 만들어보자.
// parseInt
// answer = arr2.map(n => parseInt(n))
answer = arr2.map(parseInt);

console.log(answer);

///////////////////////////////////////////////////////////////////////////////////////

const arr3 = [
  {
    name: 'jun',
    age: 18,
  },
  {
    name: 'alex',
    age: 28,
  },
  {
    name: 'ken',
    age: 38,
  },
];
// 를 활용하여
const newArr3 = [18, 28, 38];
// 를 만들어보자.

answer = arr3.map((obj) => obj.age);
console.log(answer);

///////////////////////////////////////////////////////////////////////////////////////

const arr4 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
// 를 활용하여
// 짝수만 들어있는 array를 만들어보자.

// 짝수이면서 5이상인 숫자만 들어있는 array를 만들어보자.
answer = arr4.filter((n) => n > 5 && !(n % 2));
///////////////////////////////////////////////////////////////////////////////////////
console.log(answer);

const arr5 = [
  {
    name: 'jun',
    age: 18,
  },
  {
    name: 'alex',
    age: 28,
  },
  {
    name: 'ken',
    age: 38,
  },
  {
    name: 'beemo',
    age: 48,
  },
  {
    name: 'lynda',
    age: 8,
  },
];
// 를 활용하여
// age가 30 이하인 사람들의 정보가 담긴 array를 만들어보자.
answer = arr5.filter((obj) => obj.age <= 30);
console.log(answer);
// age가 30 이하인 사람들의 이름이 담긴 array를 만들어보자.
// answer = arr5.filter(obj => obj.age <= 30).map(obj => obj.name);
answer = answer.map(obj => obj.name);
console.log(answer);
