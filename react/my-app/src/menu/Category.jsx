import MenuDetail from "./MenuDetail"
import style from "./Menu.module.css"

// const menuObj = {
//   "COFFEE": [
//     {
//       "lable": "아메리카노",
//       "price": "5.0/5.5"
//     },
//     {
//       "lable": "카페라떼",
//       "price": "6.0/6.5"
//     },
//     {
//       "lable": "바닐라라떼",
//       "price": "6.0/6.5"
//     },
//     {
//       "lable": "카라멜마끼아또",
//       "price": "6.5/7.0"
//     },
//   ],
//   "ADE": [
//     {
//       "lable": "레몬에이드",
//       "price": "6.0"
//     },
//     {
//       "lable": "자몽에이드",
//       "price": "6.0"
//     },
//     {
//       "lable": "유자에이드",
//       "price": "6.0"
//     },
//   ]
// }
export default function Category({ menus, children }) {
  return (
    <div>
      <h3 className={style.textCenter}>{children}</h3>
      <hr />
      {
        menus.map(({ lable, price }) =>
          <MenuDetail lable={lable} price={price} />)
      }
    </div>
  )
}
