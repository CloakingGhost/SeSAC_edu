console.log("Hello, World!");
console.log(42);
console.log({ name: "Alice", age: 25 });
console.log();
console.log();

console.error("This is an error message");
console.log();
console.log();

console.warn("This is a warning message");
console.log();
console.log();

console.info("This is some informational message");
console.log();
console.log();

const users = [
  { id: 1, name: "Alice", age: 25 },
  { id: 2, name: "Bob", age: 30 },
  { id: 3, name: "Charlie", age: 35 }
];
console.table(users);
console.log();
console.log();

console.group("User Details");
console.log("Name: Alice");
console.log("Age: 25");
console.groupEnd();
console.log();
console.log();

console.time("Time taken");
// Some code you want to measure
for (let i = 0; i < 1000000; i++) {}
console.timeEnd("Time taken");
console.log();
console.log();

const x = 5;
console.assert(x > 10, "x is not greater than 10");
console.log();
console.log();

function a() {
  function b() {
    console.trace("Trace the function calls");
  }
  b();
}
a();
console.log();
console.log();

console.count("Counter");
console.count("Counter");
console.countReset("Counter");
console.count("Counter");
console.log();
console.log();

const obj = { name: "Alice", age: 25, job: "Developer" };
console.dir(obj);
console.log();
console.log();

console.groupCollapsed("Collapsed Group");
console.log("This message is inside a collapsed group");
console.groupEnd();
console.log();
console.log();

console.profile("Performance Test");
// Code to profile
for (let i = 0; i < 1000000; i++) {}
console.profileEnd("Performance Test");
console.log();
console.log();

// document.write('<body></body>')
// const element = document.querySelector("body");
// console.dirxml(element);
// console.log();
// console.log();

// console.log(console.memory);
// console.log();
// console.log();

console.time("Process");
// Some code
console.timeLog("Process");
// Some more code
console.timeEnd("Process");



// AND 연산자 &&
// 치킨 먹고 싶다 | 돈이 있다 => 먹을 수 있다
// 치킨 먹고 싶다 | 돈이 없다 => 먹을 수 없다
// 치킨 먹기 싫다 | 돈이 있다 => 먹을 수 없다
// 치킨 먹기 싫다 | 돈이 없다 => 먹을 수 없다

// OR 연산자 ||
// 우유가 있다 | 물이 있다 => 마실 수 있다
// 우유가 있다 | 물이 없다 => 마실 수 있다
// 우유가 없다 | 물이 있다 => 마실 수 있다
// 우유가 없다 | 물이 없다 => 마실 수 없다


