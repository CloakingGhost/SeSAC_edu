/* 
API 실습 a, b번 문제

"https://api.themoviedb.org/3/movie/now_playing"

"https://api.themoviedb.org/3/movie/{movie_id}"

"eab8c9893e725b2e167187cef66bae3d" */

const BASE_URL = "https://api.themoviedb.org/3"

const paramsObject = {
  api_key: "eab8c9893e725b2e167187cef66bae3d"
}

function updatePath(newPath) {
  if (newPath[0] !== "/") newPath = `/${newPath}`
  return newPath
}

function makeURL(url, path, params) {
  try {
    path = updatePath(path)
    params = new URLSearchParams(params)
    return `${url}${path}?${params}`
  } catch (error) {
    return error
  }

}
async function getMovies(URL) {
  const response = await fetch(URL)
  const data = await response.json()

  return data.results
}
function getMoviesOver7Point(movies) {
  return movies.filter(m => m.vote_average >= 7)
}
async function main() {
  let path = "movie/now_playing"
  let URL = makeURL(BASE_URL, path, paramsObject)
  // console.log(URL)
  const movies = await getMovies(URL)
  const filterMovies = getMoviesOver7Point(movies)
  console.log(filterMovies)
}
main()