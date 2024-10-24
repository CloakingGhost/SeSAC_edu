const first = () => {
  function inner() {
    console.log('inner');
  }
  inner();
  console.log('동기 작업 1');
};

const second = () => {
  setTimeout(() => {
    console.log('비동기 작업 1');
  }, 3000);
};

const third = () => {
  setTimeout(() => {
    console.log('비동기 작업 2');
  }, 1000);
};

const fourth = () => {
  console.log('동기 작업 2');
};

first();
second();
third();
fourth();