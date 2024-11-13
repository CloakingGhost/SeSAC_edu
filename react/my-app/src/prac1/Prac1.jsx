import Input from "./Input";
import ButtonEventUpgrade from "./ButtonEventUpgrade";
import ButtonEvent from "./ButtonEvent";

const colorWhite = "#fff";
const btnProps = [
  {
    onClick: () => {
      alert("확인");
    },
    textContent: "확인",
    style: {
      backgroundColor: "blue",
    },
  },
  {
    onClick: () => {
      alert("취소");
    },
    textContent: "취소",
    style: {
      backgroundColor: "tomato",
    },
  },
  {
    onClick: () => {
      alert("보류");
    },
    textContent: "보류",
    style: {
      backgroundColor: "gray",
    },
  },
  {
    onClick: () => {
      alert("1억년");
    },
    textContent: "1억년",
    style: {
      backgroundColor: "pink",
    },
  },
];
export default function Prac1() {
  return (
    <div>
      <ButtonEvent></ButtonEvent>
      <Input></Input>
      {btnProps.map(({ style, textContent, onClick }) => {
        style.color = colorWhite;
        return (
          <ButtonEventUpgrade key={textContent} onClick={onClick} style={style}>
            {textContent}
          </ButtonEventUpgrade>
        );
      })}
      <ButtonEventUpgrade onClick={() => alert("haha")}>
        haha
      </ButtonEventUpgrade>
    </div>
  );
}
