// 필요한 것
// let num = 1 초기값
// num을 하나씩 증가시킬 것
// num 이 9가 되면 멈출 예정
// 9가 되기 전에는 계속 실행.

// while -> 특정 조건에서 반복을 멈춥니다.

// while (true일 때 아래 코드를 실행 : condition){
// 반복될 코드
// }


// let num = 1;

// while (num < 6) {
//   console.log(num * 2);
//   num++;
// }

// num = 0
// while (true) {
//   console.log(num)
//   num += 2
//   if (num === 10) break;
// }

// while :
// condition이 true면 계속 진행
// condition이 false면 멈춰
// 언젠가 condition이 바뀌어야 한다
// 그래야 멈출 수 있다.
// 따라서 변수가 필요하다.

// 하고 싶은 것
// 1 ~ 9 까지의 숫자를 사용하고 싶다.

// 필요한 것
// let num = 1 // 초기값
// num을 하나씩 증가 시킬 것
// num이 9가 되면 멈출 예정
// 9가 됙 전에는 계속 실행.

// for(초기화; 조건식; 증감식){}

// for (let number = 1; number <= 9; number++) {
//   console.log(number)
// }

// arr이 텅 빌 때까지 element를 출력
const arr = [2, 3, 5, 1, 4]
const tmp = []
// 필요한 것
// arr의 길이가 0이 될 때까지 -> arr.length
// while을 사용하는 것이 좋겠다.
// 횟수보다 상태만 확인하면 되기 때문에
// 다른 초기식이나 증감식이 필요하지 않다
// for 문으로 표현 할 수는 있으니 
// while이 간결해 보인다

for (; arr.length;) {
  const num = arr.pop();
  console.log(num);
  tmp.push(num)
}
console.log()
while (tmp.length) { // 여기에 tmp 넣으면 배열이라는 Object는 항상 존재하여 true
  const num = tmp.shift();
  console.log(num)
  arr.unshift(num)
}

console.log(arr)

