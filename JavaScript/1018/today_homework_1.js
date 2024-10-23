let str1 = 'Hello World'
const str2 = 'Hello World'
console.log(str1,'\n', str2);

const n1 = 1;
const s1 = '1'
console.log(typeof n1, typeof s1);


let variable = '상수형 변수에는 재할당 할 수 없다.';
variable = '재할당';
console.log(variable);

const name = "이재현"
const hello = `안녕하세요. ${name} 입니다.`

const number1 = 100;
const number2 = 200;
console.log('덧셈 :', number1 + number2)
console.log(`뺄셈 : ${number1 - number2}`)
console.log(`곱셈 : ${number1 * number2}`)
console.log(`나눗셈 : ${number1 / number2}`)

const even = 6
const odd = 3
console.log(even % 2)
console.log(odd % 2)

const arr = []
for(let i = 0; i < 10; i++){
  arr.push(i + 1);
}
console.log(arr[0], arr[2], arr[8], arr[arr.length - 1])

console.log(arr)


let todo = {
  userId: 1,
  id: 1,
  title: 'delectus aut autem',
  completed: false,
};

console.log(todo.userId, todo.id, todo.title, todo.completed)

const person = new Object()
person.name = '정우영'
person.age = 20
person.city = 'seoul'
person.location='soungdong'
person['language'] = ['HTML', 'CSS', 'JavaScript']

console.log(person)