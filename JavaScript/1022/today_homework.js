const todos = [
  {
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
  }
]
for (const todo of todos) {
  const [t, c] = [todo.content,todo.isCompleted]
  console.log(`content: ${t}, isCompleted: ${c}`)
}
for (const todo of todos) {
  if (todo.todoId === 2)
    console.log(todo)
}
for (const todo of todos) {
  if (todo.todoId === 2)
    todo.isCompleted = true
}
console.log(todos)
