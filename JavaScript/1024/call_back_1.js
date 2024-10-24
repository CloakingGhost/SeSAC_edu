// 일급 객체
// 당장 몰라도 됨

// 그니까 함수도 인자로 들어갈 수 있으니까
// 아규먼트(인자)로 주어진 함수와 

// function을 인자로 전달될 때 이 함수를 콜백함수다

// function을 반환값으로 하는 function은 일급객체의 특징이다
// 콜백함수도 일급객체의 특징이다



// 정의된 함수가 나오면 넘기고
// 함수가 실행되는 코드가 보이면 그때 함수를 찾아라
function applyOperation(func, x){
  return func(x);
}

const double = x => x * 2;
const triple = x => x * 3;
const quadra = x => x * 4;

const functions = [double, triple, quadra]
// for (let func of [double, triple, quadra]){
for (let func of functions){
  applyOperation(func, 5)
}


const numbers = [1, 2, 3, 4];

const console_log = el => console.log(el)


numbers.forEach((num) => {
    console.log(num); // 1, 2, 3, 4
});

numbers.forEach(console_log); // 함수를 넘긴다.
numbers.forEach(console_log());// 함수의 결과값을 넘긴다.
