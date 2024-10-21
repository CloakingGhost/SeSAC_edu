//백틱 양끝에 어떻게 잡은거임?

let names = [1, 2, 3]

// for (변수 in Object) {

// }

// 1. 하고 싶은 동작을 나열합니다
// 2. 규칙성을 찾습니다.
// 3. 변화하는 규칙성을 conainer에 담습니다.
// 4. conainer에서 하나씩 꺼내다가 하고싶은 동작을 실행합니다.Object

// key : Object의 키값
// for (let key in Object){
// 여기에 있는 코드를 반복적으로 실생시킵니다
// 단, key가 계속 변화합니다.Object

// 여기서 하고 싶은 것은 key를 반복적으로 할당하고,
// 그 key를 사용해서 어떤 코드를 실행하는 겁니다.

// 할당을 여러번 한다.
// }

//Multiplication table
let nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]

// for(const idx in nums) {구구단cnf
//   console.log(nums[idx] * 3)
// }

//Attendance
// names = ['jun', 'beemo', 'ken', 'lynda']
// for(let idx in names) {
//   console.log(`${++idx} ${names[--idx]}`);
// }

// names = ['jun', 'beemo', 'ken']
// let ages = [18, 28, 37] 

// for(const i in names){
//   console.log(`${ages[i]}살 ${names[i]}`)
// }


// 스코프
// 나에게 영향를 미치는 공간

// Object
// 자바스크립트의 모든 참조형은 Object
// 항상 'key' : 'value'으로 존재

let sum = 0;
nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]

// for (const num of nums){
//   sum += num
// }
sum = nums.reduce((acc, curr) => acc + curr, 0)

console.log(`sum: ${sum}`)

nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]

if (!nums.length) throw console.error("Empty list");

let minNum = nums[0]
for (const num of nums) {
  if (minNum > num) {
    minNum = num
  }
}

console.log(`minNum: ${minNum}`)

// Reverse List

nums = [10, 6, 8, 5, 4]
let reversedNum = []

for (const i in nums) {
  reversedNum.push(nums[nums.length - 1 - i])
}
console.log(reversedNum)


reversedNum = []

for(const num of nums){
  reversedNum.unshift(num)
}
console.log(reversedNum)