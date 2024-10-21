// T T F
// T F T
// F T T
// F F F


// XOR 라는 것은, OR은 OR 인데 T - T 쌍인 경우를 제외한 것
const money = false;
const car = false;

console.log((money || car) && !(money && car))

const score = 99;
if (score >= 90) {
  console.log("A");
  if (score === 100)
    console.log("교수님의 총애");
} else if (score >= 80) {
  console.log("B")
} else {
  console.log("C")
  if (score < 40)
    console.log("학사경고")
}
const isWeekend = false
const nowTime = 18
const isWorkingHour = nowTime >= 9 && nowTime <= 18 // false

// 주말 일과시간
//   T     T   휴식
//   T     F   자기개발
//   F     T   일
//   F     F   휴식

let toDo = ''
if (isWeekend) {
  if (isWorkingHour) {
    toDo = '휴식'
  } else {
    toDo = '자기개발'
  }
} else {
  if (isWorkingHour){
    toDo = '일'
  } else {
    toDo = '휴식'
  }
}
console.log(toDo);

if((isWeekend || isWorkingHour) && !(isWeekend && isWorkingHour)){
  if (isWeekend){
    toDo = '자기개발'
  } else {
    toDo = '일'
  }
} else {
  toDo = '휴식'
}
console.log(toDo);

if(isWeekend ^ isWorkingHour){
  if (isWeekend){
    toDo = '자기개발'
  } else {
    toDo = '일'
  }
} else {
  toDo = '휴식'
}
console.log(toDo);