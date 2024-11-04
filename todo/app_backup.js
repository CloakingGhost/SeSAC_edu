//#region API URL
/** @type {string} API EndPoint: todos, 할 일 목록 데이터 */
const TODOS_URL = 'http://localhost:3000/todos';
/** @type {string} API EndPoint: index, 목록의 인덱스 */
const INDEX_URL = 'http://localhost:3000/index';
//#endregion

//#region 초기 변수
/** @type {Element | null} 투두 리스트*/
const todoList = document.querySelector('#todo-list');

/** @type {Element | null} 목록 추가 버튼*/
const addTodoBtn = document.querySelector('#add-todo');

/** @type {Element | null} 목록 내용 입력*/
const contentInput = document.querySelector('#todo-input');

/** @type {boolean} 중복 전송 방지*/
let isSubmitting = false;
//#endregion

//#region @typedef 모음

/**
 * @typedef {Object} todoType 할 일
 * @property {string} id 아이디
 * @property {string} content 내용
 * @property {boolean} completed 완료 여부
 */

/**
 * @typedef {Object} validateValueType
 * @property {boolean} result 사용가능 여부
 * @property {string} message 확인 결과 문구
 */

//#endregion

//#region 초기 변수에 이벤트 추가

// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
document.addEventListener('DOMContentLoaded', initTodos);

todoList.addEventListener('click', async (e) => {
  const target = e.target;

  // 완료버튼: 완료 상태 토글링 => DB(비동기 => 상태 변경 반영), UI(최소선)
  if (target.classList.contains('btn-info')) {
    const li = target.closest('li');
    const id = li.querySelector('input[name=id]').value;
    const content = li.querySelector('.content').textContent.trim();

    const todoDiv = li.querySelector('.todo');
    const isCompleted = todoDiv.dataset.completed === 'true';
    const todoType = { id, content, completed: !isCompleted };

    const result = await statusToggle(todoType);
    if (result) {
      statusToggleDisplay(target);
      todoDiv.dataset.completed = !isCompleted;
    }
  }
  // 삭제버튼: 목록 삭제
  else if (target.classList.contains('btn-danger')) {
    const li = target.closest('li');
    const id = li.querySelector('input[name=id]').value;

    const todoDiv = li.querySelector('.todo');
    const isCompleted = todoDiv.dataset.completed === 'true';
    const todoType = { id, completed: isCompleted };
    // 클라이언트 응답 확인 후 삭제 진행
    if (isDelete(isCompleted)) {
      const result = await removeTodo(todoType);
      if (result) {
        removeTodoDisplay(target);
      }
    }
  }
});

// 목록 추가: 추가버튼 클릭
addTodoBtn.addEventListener('click', async (e) => {
  // 중복 전송 방지
  // 버블링 때문인듯
  /** @todo 버블링 해결해야함 */
  e.preventDefault();
  if (isSubmitting) return;
  isSubmitting = true;

  const resultObj = validateValue(contentInput.value);
  // 유효성 검사에 대한 결과 처리
  if (resultObj.result) {
    const response = await axios.post(
      TODOS_URL,
      await makeNewTodo(contentInput.value)
    );
    const data = response.data;

    const li = createLiTag(data);
    todoList.append(li);
    document.querySelector('#error-text').textContent = '';
    if (contentInput.classList.contains('valid')) {
      contentInput.classList.remove('valid');
    }
  } else {
    if (contentInput.classList.contains('valid')) {
      contentInput.classList.add('valid');
    }
    document.querySelector('#error-text').textContent = resultObj.message;
  }
  contentInput.value = '';
  isSubmitting = false; // 완료 후 플래그 초기화
});

// 목록 추가: 엔터
contentInput.addEventListener('keydown', (e) => {
  if (isEnterKey(e) && !isSubmitting) {
    e.preventDefault();
    addTodoBtn.click();
  }
});

//#endregion

//#region 함수 CRUD

/**
 * Todo 목록 추가용 li 태그 생성
 * @param {todoType} todo
 * @returns {HTMLLIElement} return HTMLLIElement
 */
function createLiTag(todo) {
  const li = document.createElement('li');
  li.insertAdjacentHTML('beforeend', createTodoHTML(todo));
  // 페이지 로딩 때 취소선
  if (todo.completed) {
    li.querySelector('div.content').classList.add('del');
  }
  return li;
}

/**
 * 목록 추가를 위한 데이터 모음 생성
 * @param {string} content
 * @returns {Promise<todoType>} POST를 위한 데이터
 *
 * ### 사용법
 * ```js
 *
 * makeNewTodo('강의듣기')
 * // {id : "1", content : '강의듣기', completed : false}
 *
 *
 * ```
 */
async function makeNewTodo(content) {
  const response = await axios(INDEX_URL);
  const index = response.data['index'];
  const updateIndex = await axios.put(INDEX_URL, { index: index + 1 });
  return {
    id: `${index}`,
    content,
    completed: false,
  };
}
/**
 * object의 데이터 매핑 => string
 * @param {todoType} todo
 * @returns {string} 텍스트 형태의 HTML 코드
 */
function createTodoHTML(todo) {
  return `
  <div class="todo" data-completed="${todo.completed}">
  <input type="hidden" name="id" value="${todo.id}">
  <div class="content">
  <b>${todo.content}</b>
  </div>
  <div class="me-5">
  <button class="btn btn-info">완료</button>
  </div>
  <div>
  <button class="btn btn-danger">삭제</button>
  </div>
  </div>
  `;
}

/**
 * (async) todo 상태 변경
 * @param {todoType} todo
 * @returns {Promise<todoType> | null} 변경된 todo || null
 */
async function statusToggle(todo) {
  try {
    const response = await axios.put(`${TODOS_URL}/${todo.id}`, todo);
    return response.data;
  } catch (error) {
    document.querySelector('span#error-text').textContent =
      '수정 중 오류가 발생했습니다. 다시 시도해주세요.';
    console.error(error);
    return null;
  }
}

/**
 * (UI) todo 상태 변경, 해당 목록에 최소선 토글
 * @param {EventTarget} target
 */
function statusToggleDisplay(target) {
  const todoDiv = target.closest('div.todo');
  const content = todoDiv.querySelector('div.content');
  content.classList.toggle('del');
}

/**
 * (async) 목록 삭제
 * @param {todoType} todo
 * @returns {Promise<todoType> | null} 삭제된 데이터 || null
 */
async function removeTodo(todo) {
  try {
    const response = await axios.delete(`${TODOS_URL}/${todo.id}`);
    return response.data;
  } catch (error) {
    document.querySelector('#error-text').textContent =
      '삭제 중 오류가 발생했습니다. 다시 시도해주세요.';
    console.error(error);
    return null;
  }
}
/**
 * 이벤트에 해당하는 목록을 화면에서 삭제
 * @param {EventTarget} target
 */
function removeTodoDisplay(target) {
  const todoLi = target.closest('li');
  todoLi.remove();
}
//#endregion

//#region 함수 유효성 검사

/**
 * 목록 추가시 입력값에 대한 유효성 검사
 * 1. 입력값 없음
 * 2. 최소 글자수
 * @param {string} v input.value: 사용자 입력값
 * @returns {validateValueType} {result: boolean, message: string}
 */
function validateValue(v) {
  const minimumCharacters = 2;
  v = v.trim();
  let result = true;
  let message = 'Pass validation';

  if (!v) {
    result = false;
    message = '입력값이 없습니다.';
  } else if (v.length < 2) {
    result = false;
    message = `${minimumCharacters}글자 이상 입력해주세요.`;
  }
  return { result: result, message: message };
}
//#endregion

//#region 유틸(그 외 기능)

/**
 * (async) 목록 생성
 * 최초 화면 구성
 */
async function initTodos() {
  const response = await axios.get(TODOS_URL);
  const data = response.data;
  data.forEach((todo) => {
    const li = createLiTag(todo);
    todoList.append(li);
  });
}

/**
 * 클라이언트의 삭제여부 확인
 * @param {boolean} flag 목록 완료 여부
 * @returns {boolean}
 */
function isDelete(flag) {
  const message = flag
    ? '축하드립니다🎉 목표를 달성하셨습니다. 삭제하시겠습니까?'
    : '아직 목표를 달성하지 못했습니다. 삭제하시겠습니까?';
  return confirm(message);
}

/**
 * Enter key 확인: input 태그의 입력키
 * @param {Event} e
 * @returns {boolean}
 */
function isEnterKey(e) {
  return e.keyCode === 13 || e.key === 'Enter' || e.code === 'Enter';
}

//#endregion
