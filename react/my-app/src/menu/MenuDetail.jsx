import style from "./Menu.module.css"

export default function MenuDetail({ lable, price }) {
  return (
    <div className={style.menuDetail}>
      <div className={style.textItalic}>{lable}</div>
      <div>{price}</div>
    </div>
  )
}
