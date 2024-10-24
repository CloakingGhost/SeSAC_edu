let arr = [1, 3, 5, -3, 9, 10, 23, -6, 44, 22, -10, 5, 20]

arr.forEach(n => {
  if (n > 0) {
    console.log(n)
  }
})
let result = arr.map(n => n * 2);
console.log(result)

result = arr.filter(n => n > 0 && n % 2 ? true : false)
console.log(result)

console.log(arr.findIndex(num => num === 5))

let todos = [{
  "todoId": 1,
  "content": "예습하기",
  "isCompleted": false
},
{
  "todoId": 2,
  "content": "강의듣기",
  "isCompleted": false
},
{
  "todoId": 3,
  "content": "복습하기",
  "isCompleted": false
}]

todos.forEach(el => console.log(el))

todos = [
  {
    "todoId": 1,
    "content": "예습하기",
    "isCompleted": false
  },
  {
    "todoId": 2,
    "content": "강의듣기",
    "isCompleted": true
  },
  {
    "todoId": 3,
    "content": "복습하기",
    "isCompleted": true
  }
]
todos.filter(todo => todo.isCompleted)
  .forEach(todo => console.log(todo))

const matrix = [[4, 2], [3, 2], [5, 7], [10, 1]]
matrix.forEach(row => console.log(row[1]))
result = matrix.filter(row => !((row[0] + row[1]) % 2))

console.log(result)
