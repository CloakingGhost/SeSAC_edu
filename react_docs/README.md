# 1104
DOM 조작시 하나씩 만들어서 추가했다
그때마다 브라우저는 계속해서 업데이트가 된다.

Virtual DOM을 사용하면 하나의 코드부품을 추가하여 관리에도 용이하다

JS : 비동기, this, closer
React : Virtual Dom, Component

- [React 바로가기](https://ko.react.dev/)
  - [시작하기](https://ko.react.dev/learn)
- [Vite 바로가기](https://ko.vite.dev/)
  - [시작하기](https://ko.vite.dev/guide/)
  - `npm create vite@latest my-app -- --template react`

npx : 일회용 npm, 한번 실행하고 사라짐
Vite(비트) : 배포의 생산성을 도와줌

보일러 플레이트

- `npm install`
  - dependencies : 설치

jsx : HTML + JS , HTML을 다룰수 있는 파일, HTML 처럼 생겼지만 사용문법이 좀 다름, js 내부에서 사용할 수 있는 HTML 코드

index.html : 하나의 페이지에서 fetch 등등을 통해 내용만 갈아 끼움

HMR : Hot Module Reload

SPA : Single Page Application

---
# Component

재사용 가능한 코드 조각

함수를 통해 만들어진 HTML은 함수의 이름 그 자체로 요소가 되어 활용가능하다
JSX 요소를 반환하는 함수 => 컴포넌트

자동완성 안돼면 렌치 모양 눌러

Extensions
- ES7+ React/Redux/React-Native snippets

`npm run dev` : package.json 위치에서 실행

rfce + tap


틀에 박힌 일
하나의 모양을 만들기 위해 그러한 모양을 완성 시키기위해 
라이브러리들의 집합

# 1105
git restore 되돌릴파일/폴더 : 최근 커밋으로 이동
- 추적대상이 아닌 파일은 그대로 남는다
git reset --hard 커밋아이디 : 추적대상이 아닌 파일까지도 커밋 상태로 돌린다.
- git add를 해야함
- 커밋 아이디 확인 하려면 git log를 사용해야함
git reflog
- reset으로 과거로 돌아갔을 때 미래의 커밋들도 보이게 됨
하나의 컴포넌트(코드의 조각)는 하나의 파일이다

## JSX 기초
마크업과 로직을 하나의 파일에서 작업가능

JS파일에서 HTML을 결과로 사용할 수 있다

1. 하나의 루트 엘리먼트를 반환 해야함
	- 형제 태그를 반환할 수 없음
2. <> </> 빈 태그를 사용하여 부모태그 역할을 함
	- 화면에서는 안보임
3. 모든 태그는 닫힌 태그
	- img, br 모두 \/로 닫아야함
4. 대부분 캐멀케이스
	- class, for 등 JS에서 사용되는 예약어는 HTML에 속성으로 사용할 수 없음
		- htmlFor, className
5. 단일 속성 값은 지정해야함
	- <input type="checkbox" checked/> 안 됨
	- <input type="checkbox" checked={true}/> 됨

	# 1106
	
	컴포넌트의 구조가 같을 때
	내용들만 바꾸고 싶다
	변수로 만들자
	이 변수는 외부에서 입력받고 싶다
	함수가 call 될 때 인자로 받는다
	react에서 외부 변수는 Object로 받게 된다.
	구조 분해 할당을 사용하여 Object의 값을 변수에 할당한다.
	
	하위에서 상위로
	보내기 함든다
	하위에서는 상위가 누군지 알 수 없다
	직관적으로 props와 같은 방식으로 전달은 어렵다
	
	이벤트 || 전역상태관리 등을 사용하여 조금 더 복잡한 방식으로 전달 됨
	
	react 에서는 props를 변경시키는 것을 권장하지 않는다
	
	
	버튼을 만들어서 이를 사용하는 빨간 버튼을 만든다
	내용만 바꿔서 사용 할 수 있는 
	빨간 버튼이 생성된다.
	금지 버튼, 취소 버튼, 제한 버튼 불법 정지 등등
	
	컴포넌트 파스칼 케이스
	일반 태그들과 구분하기 위함
	
# 컴포넌트 사이 글자 넣기
	<CancelButton>취소<\/CancelButton>
	함수에 children으로 받을 수 있음
	props에 넣지 않아도 된다
	<CancelButton><div>태그<\/div><\/CancelButton>
	똑같이 children으로 들어옴 
	낱개 여러개도 됨 => 리스트
	하나로 묶은 태그 뭉치도 됨
	
	태그를 변수에 넣을 수 있음
	
	children은 파라미터로 안받아도 됨