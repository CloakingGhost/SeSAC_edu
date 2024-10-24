// 객체 - something
// - 상태
// - 행동

// key : value

// 이 객체들이 상호작용하도록 만든 것이 객체지향

const jun = {
  name: 'jun',
  age: 18,
  gender: 'M',
  walk() {
    console.log('걷는다!')
  },
  introduce(me){
    console.log(me)
  }
}
jun.walk()
jun.introduce(jun)


const person = {
  name: 'John',
  friends: ['Jane', 'Mike'],
  
  printFriends_wrong() {
    // 어디서 실행 됐는지 찾아야함
    // undefined 출력 됨
    // let _this = this
      this.friends.forEach(function(friend) {
          console.log(this.name + ' knows ' + friend);  // this는 window
      });
  },
  
  printFriends_right() {
    // 콜백함수 내부에서는 에로우 펑션을 사용하자
      this.friends.forEach((friend) => {
          console.log(this.name + ' knows ' + friend);  // 정상 작동
      });
  },

};