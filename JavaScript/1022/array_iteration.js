const names = ['jun', 'beemo', 'lynda']

console.log('------ 1. for of Start -------')
// 1. for of

for (let name of names) {
  console.log(name)
}

console.log('------ 1. for of End -------')
console.log()
console.log('------ 2. for in Start -------')
// 2. for in

for (let index in names) {
  let name = names[index];
  console.log(name, index);
}

console.log('------ 2. for in End -------')
console.log()
console.log('------ 3. normal-for Start -------')
// 3. for

for (let i = 0; i < names.length; i++) {
  let name = names[i];
  console.log(name, i)
}
console.log('------ 3. normal-for End -------')
console.log()

console.log('------ 4. while Start -------')
// 4. while

let idx = 0;
while (idx < names.length) {
  let name = names[idx];
  console.log(name, idx);
  idx++;
}
console.log('------ 4. while End -------')
console.log()

// 4. while-true
console.log('------ 5. while-true Start -------')
idx = 0;
while (true) {
  let name = names[idx];
  console.log(name, idx);
  idx++;

  if (idx === names.length) {
    break;
  }
}
console.log('------ 5. while-true End -------')