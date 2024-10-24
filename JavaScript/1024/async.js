const newPromise = new Promise((resolve, reject) => {
  
  const flag = true;
  // const flag = false;

  if (flag === true) {
    resolve('작업 성공');
  } else {
    reject('작업 실패');
  }
});

newPromise
  .then((result) => {
    console.log(result);
    return 'hahahaha';
  })
  .then((result) => {
    console.log(result)
  })
  .catch((error) => {
    console.error(error);
  })
  .finally(() => {
    console.log('작업 완료');
  });
