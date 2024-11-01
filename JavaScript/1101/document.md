**form**

- event.preventDefault()
  - 데이터(JSON)을 받아 DOM을 조작한다.
  - form을 통해 데이터를 받아서
  - fetch로 그 데이터로 요청을 보낸다
  - 이 결과로 응답 데이터를 받아서 DOM 조작의 활용한다

submit 이벤트 -> data를 서버로 전달하기 위해서 사용  
form의 submit 이벤트 고~~급 a태그 느낌으로  
data를 전달(요청) 후 응답을 받아서 브라우저에서 띄워줍니다.

우리는 그 응답 자체를 사용하고 싶은 것이 아니라,  
응답이 가지고 있는 data를 사용해서 DOM을 조작해 화면을 띄워주고 싶은 것.

=> 기본 요청 => 응답의 이벤트를 막고, 내가 직접 만들자!

form을 사용하면 화면이 refresh가 되기 때문에 이동이 발생한다.  
사용자의 편의를 위해 이러한 이벤트를 막아 데이터를 비동기로 보내는 과정으로 변한다.

---

**Ajax**

자바스크립트를 이용해서 비동기 방식으로 데이터를 가져오는 방법

---

**Validation**  
클라이언트 / 서버  
두 곳에서 유효성 검사를 실시한다.

클라이언트는 UX 부분에서 불편함을 줄이는 쪽을 목표로 한다.  
예 \) 회원가입 시 비밀번호 입력란과 비밀번화 확인란에서 검사 없이 회원가입 버튼을 눌렀다가 달라서 처음부터 다시 가입양식을 작성한다면 불편하겠다

---

이전에 사용했던 fetch 예제와 구글 검색방법을 form으로 대체해 봤다

결과는 모두 페이지 이동되면서 JSON 혹은 HTML을 응답 받게된다

이를 event.preventDefault()를 사용하여 form을 막는다  
form을 선택
이전의 fetch 동작을 복붙(javascript-placeholder)

async/await으로 변경

form을 입력해 제출
DB에 저장하려고
성공했을 때 데이터를 받고 싶다

form에 직접적인 action/method를 입력할 필요 없다
이벤트 막아서 비동기통신 할거니까

입력값 가져와서 fetch에 전달(요청)
입력값을 보내고 서버로 부터 데이터를 받아와서 확인
이 데이터는 입력값과는 다른 녀석이다 왜? 서버에서 받은 데이터를 출력한것이기 때문

이러한 방식이 CSR이다.

```JavaScript
const form = document.querySelector('form')
form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = new FormData(form);
    const objectData = Object.fromEntries(formData);
    const jsonData = JSON.stringify(objectData);
    console.log(jsonData;)
})
```

---  
html : 구조  
css : 구도 스타일  
js : 기능  

js파일은 HTML코드보다 상단에 위치 할 경우 생성이 되지 않은 HTML에 대해 DOM 조작이 불가했다.  
때문에 body tag 하단에 js파일이 위치했다
파일의 위치적인 제한을 해결하며 비동기적으로 js를 다운로드하여 실행속도 개선을 할 수 있기도 하다  
**defer / async**
둘 다 비동기적을 파일을 다운로드 한다
차이점
defer : HTML 다운로드 후 JS 실행
async : JS 다운로드 후 바로 실행 / DOM 조작이 될 수도 안될 수도 있음



---  
트리쉐이킹  
라이브러리 중에서 특정 함수만 가져오는 것  

여담 : leftPad() 삭제하여 babel이라는 자바스크립트 컴파일러 회사가 터져버림
open source의 경우 여기저기 라이브러리들이 의존관계를 가지기 때문임