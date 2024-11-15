import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

createRoot(document.getElementById('root')).render(
  // 함수는 순수해서 외부의 영향을 받을 수 있다
  // 확인 차 2번 실행 시켜본다
  <StrictMode>
    <App />
  </StrictMode>
)
