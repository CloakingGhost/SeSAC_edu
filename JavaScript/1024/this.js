const person = {
  name: '철수',
  greet() {
    console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
    // 안녕하세요. 저의 이름은 철수 입니다.
    // this는 객체 person을 참조한다.
  },
};

// person.greet();

// 이건 이해 됨
// 일급객체의 특징에 따라 함수를 부여한것이기 때문
function greet() {
  console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
}

const boy =  {
  name: '철수',
  greet_boy: function() {
    console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
  }
};

const girl = {
  name: '영희',
  greet_girl: greet
};
// boy.greet_boy()
// girl.greet_girl()

const person2 = {
  name: '철수',
  greet: () => {
    console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
    // 화살표 함수의 this는 상위 컨텍스트의 this를 참조하므로 undefined이 출력된다.
    // 이 코드에서는 전역 컨텍스트 this를 참조한다.
  },
};

person2.greet(); // 안녕하세요. 저의 이름은 undefined 입니다.

const person3 = {
  name: '철수',
  greet() {
      const sayHi = () => {
          console.log(`안녕하세요. 저의 이름은 ${this.name} 입니다.`);
      }
      sayHi()
  },
};

person3.greet(); // 안녕하세요. 저의 이름은 철수 입니다.
