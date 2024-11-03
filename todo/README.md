# Todo List

### Tech Stack
- HTML
- CSS
- JavaScript

### Runtime Environment
- Node.js

### Web Server
- Live Server

### API Server (Mock)
- json-server@0.17.4

### Library
- axios

### IDE
- VSCode(Visual Studio Code)

## 주요기능  
- CRUD  
    - 생성: Enter키를 눌러 목록에 추가  
        - 유효성 검사를 통해 의미있는 할 일 추가
    - 조회: 전체 목록을 불러와 한 눈에 확인 가능
    - 수정: 완료 상태를 버튼으로 하여 할 일 취소선 표시
        - 데이터 베이스에 상태 즉시 반영
    - 삭제: 더 이상 필요없는 할 일을 목록에서 삭제
        - 삭제 확인 메시지를 통해 사용자의 실수 방지
- 비동기 처리
    - RESTful API를 통해 요청이 완료될 때까지 기다리지 않음
    - axios 라이브러리 사용
- 중복 전송 방지
    - Enter키로 데이터 전송 시 isSubmitting 플래그를 사용하여 중복 방지
    - 네트워크 트래픽을 줄임
- 시작 시 데이터 초기화(`DOMContentLoaded` 이벤트)
    - 할 일 목록을 불러오고 화면에 렌더링 하여 사용자가 바로 확인 가능
    
## 피드백(추가 요구사항)
- 목록의 순서 변경
- 내용 수정
- 색상을 통한 강조 효과
- 추가한 날짜 확인
    - 기간 설정과 기간 수정