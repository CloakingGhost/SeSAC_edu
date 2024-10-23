const nums = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
for (const row of nums) {
  for (const value of row) {
    // console.log(value)
  }
}

const answer = new Array()

for (const row of nums) {
  let sum = 0
  for (const value of row) {
    sum += value
  }
  answer.push(sum)
}
// console.log(answer)

answer.length = 0
for (let i = 0; i < nums.length; i++) {
  let sum = 0
  for (let j = 0; j < nums[0].length; j++) {
    sum += nums[j][i];
  }
  answer.push(sum)
}
// console.log(answer)

answer.length = 0

let inputNum1 = 3;
let inputNum2 = 4;

if (inputNum1 > inputNum2) {
  let tmp = inputNum1
  inputNum1 = inputNum2
  inputNum2 = tmp
}

for (let i = 1; i <= inputNum1; i++) {
  const arr = []
  for (let j = 1; j <= inputNum2; j++) {
    arr.push(i * j);
  }
  answer.push(arr)
}

console.log()
for (const row of answer) {
  console.log(row)
}