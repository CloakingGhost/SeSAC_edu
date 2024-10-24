function addVer1(num1, num2) {
  console.log(num1, num2);
  return num1 + num2;
}

const addVer2 = function (num1, num2) {
  console.log(num1, num2);
  return num1 + num2;
}

const addVer3 = (num1, num2) => {
  console.log(num1, num2);
  return num1 + num2;
}

const calc = {
  addVer4: function (num1, num2) {
    console.log(num1, num2);
    return num1 + num2;
  },
  addVer5: (num1, num2) => {
    console.log(num1, num2);
    return num1 + num2;
  },
  addVer6(num1, num2) {
    console.log(num1, num2);
    return num1 + num2;
  }
}