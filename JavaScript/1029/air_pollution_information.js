/* 
공공데이터 포털
1. 회원가입
2. 활용신청

활용신청 완료 후 
마이페이지 - API신청 클릭 - 아래쪽 활용신청한 데이터 제목 클릭

개발계정 상세보기에서 밑으로 내리면 상세기능정보가 있다면 이를 사용하여
미리 데이터의 형태 확인한다


참고 문서를 통해 옵션에 대한 설명을 읽어야할 필요가 있을 수 있다.

엔드 포인트는 API를 접근하기 위한 BASE_URL이 된다
인증키는 2가지로 Encoding / Decoding이 둘 중 하나로 사용하게 된다.


응답의 구조 예시가 따로 없기 때문에 테스트 데이터를 확인해야 한다.

옵션이 하나라도 다르면 완전히 다른 데이터가 온다
옵션에서 오타가 나더라도 잘못된 옵션은 무시하고 옳은 데이터만
확인하여 전달준다
오타 확인이 중요하다, 복붙을 잘 쓰자

특히나 결측지가 있을 수 있다 이건 진짜 중요하다
결과값이 안나오게 되는 원인이 된다.


datum -> data
샘플데이터의 URL을 그대로 사용하면된다
나의 API 키가 알맞은 것으로 자동으로 추가됨
즉 샘플데이터를 사용할 때 나의 API 키를 사용하여 데이터를 준다
https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=vw2EnZ0GgIZHggwDsu7aUHke764BQdqeKf5lKhPTeHutsRpAtgmD7OJlVeTbpbB2TIZ4RavZN01PSlcYZx%2B2aA%3D%3D&returnType=json&numOfRows=100&pageNo=1&sidoName=%EC%84%9C%EC%9A%B8&ver=1.0

특수기호들이 변해있는 것이 보인다
애당초 이렇게만드는게 잘못된 것이다.
vw2EnZ0GgIZHggwDsu7aUHke764BQdqeKf5lKhPTeHutsRpAtgmD7OJlVeTbpbB2TIZ4RavZN01PSlcYZx%2B2aA%3D%3D
vw2EnZ0GgIZHggwDsu7aUHke764BQdqeKf5lKhPTeHutsRpAtgmD7OJlVeTbpbB2TIZ4RavZN01PSlcYZx+2aA==

서비스의 안정성을 위한다면 else / 
예기치 못한 상황까지 거른다면 if / 서버가 터질지언정 디테일을 잡는다


문자열 비교는 아스키 코드

-------------------

API 문서를 만든다면 데이터의 타입이 바뀌게끔 만들면 안된다
결측치 -> "_", 정상값 -> 7 인 경우
아우르기 위해 숫자값도 문자로 만든다면 좋은 데이터가 아니다
또한 데이터 값의 정상범위도 있어야 활용에 안정적인 데이터다

그럼 결측치를 어떻게 할까?
*/

/* 
여러개의 데이터
순서가 있다

접근 / 수정 -> array
데이터 삽입 / 삭제 -> Linked List

큐 -> 선입 선출
스택 -> 후입 선출

*/

/* 
데이터를 한번에 주는 것은 DB에 부담이 되고 
전송시에도 서버에 부담이 된다.
페이지 네이션으로 데이터를 가져오자
*/

/* 
큰 데이터가 온다면 어떻게 분류를 할까
결과를 먼저 생각해보자

어떤 데이터를 만들고 싶은가

데이터가 어떻게 생기면 좋겠다.
*/


/* 
baseUrl
path
params

serviceKey
1. 시도별 실시간 측정정보 조회의 서울의 데이터에 대해, 초 미세먼지 농도가 가장 낮은 stationName을 찾으시오.
2. 종로구의 pm10Value, pm25Value의 1달치 데이터를 정리하시오.
*/
const serviceKey = 'vw2EnZ0GgIZHggwDsu7aUHke764BQdqeKf5lKhPTeHutsRpAtgmD7OJlVeTbpbB2TIZ4RavZN01PSlcYZx+2aA=='
const baseUrl = 'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc'
const path = '/getCtprvnRltmMesureDnsty'
const paramsObject = {
  serviceKey: serviceKey,
  returnType: 'json',
  numOfRows: 100,
  pageNo: 1,
  sidoName: '서울',
  ver: 1.0
}
new URLSearchParams(paramsObject)