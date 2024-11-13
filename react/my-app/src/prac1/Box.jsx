import style from "./Box.module.css";
export default function Box() {
  return (
    <div
      className={style.box}
      onMouseEnter={function (e) {
        e.target.style.backgroundColor = "#000000";
      }}
      onMouseLeave={function (e) {
        e.target.style.backgroundColor = "#ffffff";
      }}
    >
      Box
    </div>
  );
}
