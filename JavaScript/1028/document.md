### 백엔드
- 비즈니스 로직
- DB와 통신

### 프론트엔드
- HTML, CSS, JS을 활용하여 긍정적인 사용자 경험을 제공함


### SPA
- Single Page Appliction
- 브라우저에 요청의 결과로 HTML, CSS, JS가 들어온다.
  - 브라우저도 프론트엔드와 동일시 된다.
- 프론트엔드에서 백엔드로 데이터를 요청한다.



### API
어떤 요청을 보냈을 때 어떤 데이터가 주는지 알고 있어야 한다.
**API 문서**에 있다.


### RESTfull API
- 이쁜 API
- URL을 통해 요청을 식별할 수 있다.


### URL
- 생김새를 알아야 한다.
- 도메인 + 페스파라미터 + 쿼리파라미터

### Fetch
- API와 URL이 준비되 었다면 사용해야한다.
- 대표적인 비동기 통신 API이다.
- HTTP를 사용하여 데이터를 주고 받음

1.  URL을 통해 요청을 하고 기다려야 함(await)
  - 인터넷을 사용하기 때문에 기다려야 함
  - Header와 body에 약속에 맞는 데이터를 요청
2. 응답으로 데이터가 온다
  - JSON, HTML, XML, Text, ... 등등 다양한 데이터 형태가 있다
3. 응답 이후 데이터 파싱에도 await를 통해 결과를 기다려야 하는데
  - Fetch는 그렇게 설계가 되어있음
4. 이제 데이터를 사용할 수 있음

#### 요청을 보낼 때
1. URL
2. Method
3. Data(API key, values)

### 실습
[TMDB API](https://developer.themoviedb.org/docs/getting-started)

1. API Reference
2. Getting Started
3. Get API Key
4. Header API 읽기 액세스 토큰 추가
API 키 // eab8c9893e725b2e167187cef66bae3d 

API 읽기 액세스 토큰 // 
eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlYWI4Yzk4OTNlNzI1YjJlMTY3MTg3Y2VmNjZiYWUzZCIsIm5iZiI6MTcyMzQ0OTA0NS4yNzgyMTUsInN1YiI6IjYxMDM1NDljNGU1MmVkMDA3NTg3ZDhjYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7jp_CFU3rlNfbk_sFKDq87w1atDZfompDS3JDjvCxtU 

**End Point**
- API URL