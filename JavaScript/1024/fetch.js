const url = 'https://jsonplaceholder.typicode.com/todos/1';


const data = fetch(url)
  .then((response) => {
    // 네트워크 요청 결과 데이터를 JSON 구조로 변환 후 반환
    return response.json();
  })
  .then((json) => {
    // JSON 구조로 변환된 데이터 처리
    console.log(json);
  })
  .catch((error) => {
    console.log(error);
  });

// { userId: 1, id: 1, title: 'delectus aut autem', completed: false }
const newPromise = new Promise((resolve, reject) => {

  const flag = true;
  // const flag = false;

  if (flag === true) {
    resolve('작업 성공');
  } else {
    reject('작업 실패');
  }
});