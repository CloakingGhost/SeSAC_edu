const posts = [
  { id: 1, title: '첫 번째 포스트', content: '첫 번째 포스트 내용' },
  { id: 2, title: '두 번째 포스트', content: '두 번째 포스트 내용' },
  { id: 3, title: '세 번째 포스트', content: '세 번째 포스트 내용' },
];
const comments = [
  { id: 1, postId: 1, content: '첫 번째 댓글' },
  { id: 2, postId: 2, content: '두 번째 댓글' },
  { id: 3, postId: 1, content: '세 번째 댓글' },
  { id: 4, postId: 2, content: '네 번째 댓글' },
  { id: 5, postId: 3, content: '다섯 번째 댓글' },
  { id: 6, postId: 2, content: '여섯 번째 댓글' },
  { id: 7, postId: 3, content: '일곱 번째 댓글' },
  { id: 8, postId: 3, content: '여덟 번째 댓글' },
  { id: 9, postId: 1, content: '아홉 번째 댓글' },
  { id: 10, postId: 3, content: '열 번째 댓글' },
];
// posts.forEach(p => console.log(p.id, p.title, p.content))
// console.log()
// comments.forEach(c => { if (c.postId === 1) console.log(c) })
// console.log()


// 포스트 하나 돌 때
// 포스트 id에 해당하는 comment 찾아서 p.id : [c, c, c, ...] push
const sorted = []
for (const p of posts) {
  const obj = {}
  const key = 'post'
  obj[p.id] = p
  obj[key] = []
  for (const c of comments) {
    if (p.id === c.postId) {
      obj[key].push(c)
    }
  }

  // console.log(obj);
  sorted.push(obj)
}
// console.log(sorted)
for (const obj of sorted) {
  // console.log(obj) 
  let num = -1
  for (const key in obj) {
    if (key === 'post') {
      console.log(`${num}번 Post의 Comments`)
      obj[key].forEach(v => console.log(v))
    } else {
      num = obj[key].id
      console.log(`${num}번`)
      console.log(obj[key])
    }
  }

}