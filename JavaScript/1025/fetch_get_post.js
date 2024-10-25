// API를 사용해본다

fetch('https://jsonplaceholder.typicode.com/posts/1')
  .then((response) => response.json())
  .then((json) => {
    // console.log(json)
    const title = json.title
    // console.log(title)
  })
  .catch((error) => console.error(error));


async function getPostById(postId) {
  const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${postId}`)
  // console.log(response)
  // 응답의 결과가 json이기 때문이다
  // 결과가 html
  const data = await response.json()
  console.log(data)

  const title = data.title
  console.log(title)
}
getPostById(101);

async function getPosts() {
  const response = await fetch(`https://jsonplaceholder.typicode.com/posts`)
  const data = await response.json()
  // console.log(data)
  const title = data.map(value => value.title)
  console.log(title)

}
// getPosts()


//posts에 한개 추가 할게
// ...com/posts/create <= 행위가 작성되면 RESTful API하지 않음, method에 작성했기 때문에
async function createPost() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/posts', {
      method: 'POST',
      body: JSON.stringify({
        title: 'foo',
        body: 'bar',
        userId: 1,
      }),
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
      },
    });

    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Error:', error);
  }
}

// createPost();

console.log("1")

const str = JSON.stringify({
  title: 'foo',
  body: 'bar',
  userId: 1,
})
console.log(str)

const tmp = '{"title":"foo","body":"bar","userId":1}'
console.log(JSON.parse(tmp))

// URL
// id
// method
// body