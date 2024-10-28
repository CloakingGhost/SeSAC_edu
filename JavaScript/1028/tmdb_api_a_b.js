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

function getPopularMovie(movies) {
  let movie = null
  let maxVoteAverage = 0
  for (const m of movies) {
    if (maxVoteAverage < m.vote_average) {
      maxVoteAverage = m.vote_average
      movie = m
    }
  }
  return movie
}

async function getDetailMovie(URL) {
  const response = await fetch(URL)
  return await response.json()
}

function getRevenue(movie) {
  return movie.revenue
}
async function main() {
  let path = "movie/now_playing"
  let URL = makeURL(BASE_URL, path, paramsObject)
  // console.log(URL)
  const movies = await getMovies(URL)

  const movie = getPopularMovie(movies)
  path = `movie/${movie.id}`
  URL = makeURL(BASE_URL, path, paramsObject)
  const detailMovie = await getDetailMovie(URL)
  const revenue = getRevenue(detailMovie)
  console.log(revenue)
}
main()