let arr1 = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]

let arr2 = [...arr1] // 새롭게 할당 됨. 각각의 데이터의 주소값을 넣음
let arr3 = arr1

arr1[1] = 100
arr1[0][2] = 999

console.log(arr1)
console.log(arr2) // 새로운 배열임
console.log(arr3)


let arr4 = [
  [[1], [2, 3]],
  [[4], [5, 6]],
  [[7], [8, 9]]
]

let arr5 = [...arr4]// 얉은 복사

arr4[0][0][0] = 999

// console.log(arr5)