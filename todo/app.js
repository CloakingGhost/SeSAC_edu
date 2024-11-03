// API 베이스 URL
const URL = 'http://localhost:3000/todos';
const INDEX_URL = 'http://localhost:3000/index';

// DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.
document.addEventListener('DOMContentLoaded', initTodos);
const todoList = document.querySelector('#todo-list');
const addTodoBtn = document.querySelector('#add-todo');
const content = document.querySelector('#todo-input');



let isSubmitting = false; // 중복 전송 방지
/* Create */
addTodoBtn.addEventListener('click', async (e) => {
  // 중복 전송 방지
  e.preventDefault();
  if (isSubmitting) return;
  isSubmitting = true;
  // 추가 버튼 누른다
  // 인풋태그 값 가져온다
  // axios로 DB에 보낸다
  // 등록된거 확인 되면
  // 화면에 뿌린다
  const error = document.querySelector('#input-error');
  const validationObj = validateValue(content.value);
  content.classList.remove('valid');
  if (validationObj.result) {
    const response = await axios.post(URL, await createTodo(content.value));
    const data = response.data;

    const li = createLiTag(data);
    todoList.append(li);
    error.textContent = '';
  } else {
    content.classList.add('valid');
    error.textContent = validationObj.message;
  }
  content.value = '';
  isSubmitting = false; // 완료 후 플래그 초기화
});
content.addEventListener('keydown', (e) => {
  if (isEnterKey(e) && !isSubmitting) {
    e.preventDefault();
    addTodoBtn.click();
  }
});
function isEnterKey(e) {
  return e.keyCode === 13 || e.key === 'Enter' || e.code === 'Enter';
}
// todo li 생성
function createLiTag(todo) {
  const li = document.createElement('li');
  li.insertAdjacentHTML('beforeend', createTodoHTML(todo));
  // li 안에 값(요소들) 넣고 버튼 찾아서 이벤트 추가
  const completedBtn = li.querySelector('.btn-info');
  const deleteBtn = li.querySelector('.btn-danger');
  // 클로저: todo가 남아있음, e를 통해 데이터를 찾는 작업 안해도 됨
  completedBtn.addEventListener('click', async (e) => {
    todo = await statusToggle(todo);
    statusToggleDisplay(e);
  });
  // 클로저: todo가 남아있음
  deleteBtn.addEventListener('click', async (e) => {
    const result = await removeTodo(todo);
    
    if (result) {
      removeTodoDisplay(e);
    }
  });
  // 페이지 로딩 때 취소선
  if (todo.completed) {
    li.querySelector('div.content').classList.add('del');
  }
  return li;
}
// DB에 추가
async function createTodo(content) {
  const response = await axios(INDEX_URL);
  const index = response.data['index'];
  const updateIndex = await axios.put(INDEX_URL, { index: index + 1 });
  return {
    id: `${index}`,
    content: content,
    completed: false,
  };
}
function createTodoHTML(todo) {
  /* input "${todo.completed}" 삭제 해야함 */
  return `
  <div class="todo" data-completed="${todo.completed}">
    <input type="hidden" name="id" value="${todo.id}">
    
    <input type="hidden" name="completed" value="${todo.completed}">
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
/* Update */
// 완료 버튼 누르면
// 해당 content에 class 추가  .del {text-decoration: line-through}
// <input type="hidden" name="completed" value="${todo.completed}">
// fetch로 DB 바꿔

// completed 바꾸기
async function statusToggle(todo) {
  try {
    todo.completed = !todo.completed;
    const response = await axios.put(`${URL}/${todo.id}`, todo);
    return response.data;
  } catch (error) {
    document.querySelector('#input-error').textContent =
      '오류가 발생했습니다. 다시 시도해주세요.';
    console.log(error);
    return null;
  }
}
function statusToggleDisplay(e) {
  const todo = e.target.closest('div.todo');
  const content = todo.querySelector('div.content');
  content.classList.toggle('del');
}

/* Delete */
// 삭제
// 삭제 전에 comfirm 입력 받아서
// 축하드립니다 목표를 달성하셨습니다. 해당 목표를 삭제하시겠습니까?
// 아직 목표를 달성하지 못했습니다. 목표를 삭제하시겠습니까?

// ture 일 경우
// id 값 가지고
//     id 값????? DB에 index 값 하나 만들어야 될듯?
// 해당 값 DB에서 제거
// 제거 후 화면에서도 제거
// 아님 일부만 지울까? <- 이게 UX 더 좋긴 함
async function removeTodo(todo) {
  try {
    if (checkDel(todo.completed)) {
      const response = await axios.delete(`${URL}/${todo.id}`);
      return true;
    } else {
      return false
    }
  } catch (error) {
    document.querySelector('#input-error').textContent =
      '오류가 발생했습니다. 다시 시도해주세요.';
    console.error(error);
    return false;
  }
  // DB에서 내용 지우기
  // 화면에서 내용 지우기
  // todo.closest('li').remove();
}
function removeTodoDisplay(e) {
  const todoLi = e.target.closest('li');
  todoLi.remove();
}
/* Init */
async function initTodos() {
  const response = await axios.get(URL);
  const data = response.data;
  data.forEach((todo) => {
    const li = createLiTag(todo);
    todoList.append(li);
  });
}

/* Validation */

// 유효성 검사 뭐가 있을까
// 빈값일 경우 => 입력값이 없습니다.
// 최소 2글자 이상, trim 사용 => 2글자 이상 입력해주세요

/* Delete 전용 */
function checkDel(flag) {
  const message = flag
    ? '축하드립니다🎉 목표를 달성하셨습니다. 삭제하시겠습니까?'
    : '아직 목표를 달성하지 못했습니다. 삭제하시겠습니까?';
  return confirm(message);
}

/* Create 전용 */
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
