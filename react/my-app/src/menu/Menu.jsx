import Category from "./Category"
import style from "./Menu.module.css"
import jsonMenu from "./menu.json"
export default function Menu() {
  const menus = jsonMenu.results
  const categories = Object.keys(menus)
  return (
    <div>
      <h2 className={[style.textCenter, style.colorBrown].join(' ')}>MENU</h2>
      {
        categories.map(category =>
          <Category menus={menus[category]}>{category}</Category>
        )
      }
    </div>
  )
}
