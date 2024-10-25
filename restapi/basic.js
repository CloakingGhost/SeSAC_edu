async function readTodos() {
  const response = await fetch("http://localhost:3000/todos")
  const data = await response.json()

  return data
}
async function readTodosEx() {
  let response = await readTodos()
  console.log(response)

}
readTodosEx()