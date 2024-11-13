import ImgUrl from "./ImgUrl"
import Product from "./Product"
import User from "./User"
import Name from "./Name"
import Button from "./Button"
import Card from "./Card"
import Menu from "./menu/Menu"

const colorWhite = "#fff";
const border = "1px solid black"
const btnStyle = [
  {
    textContent: "확인",
    style: {
      backgroundColor: "blue"
    }
  },
  {
    textContent: "취소",
    style: {
      backgroundColor: "tomato"
    }
  },
  {
    textContent: "보류",
    style: {
      backgroundColor: "gray"
    }
  },
  {
    textContent: "1억년",
    style: {
      backgroundColor: "pink"
    }
  },
]
const cardStyle = [
  {
    style: {
      width: 100,
      height: 100,
      border
    },
    title: "Title 1",
    textContent: "Content for Title 1"
  },
  {
    style: {
      width: 150,
      height: 150,
      border
    },
    title: "Title 2",
    textContent: "Content for Title 2"
  }
]

export default function Profile() {
  return (
    <>
      <Name></Name>
      <User></User>
      <Product></Product>
      <ImgUrl></ImgUrl>
      <div>
        {
          btnStyle.map(({ style, textContent }, idx) => {
            style.color = colorWhite
            return <Button
              key={idx + 1}
              style={style}>
              {textContent}
            </Button>
          })
        }
      </div>
      <div>
        {
          cardStyle.map(({ title, style, textContent }, idx) =>
            <Card
              key={idx + 1}
              title={title}
              style={style}
            >{textContent}
            </Card>)
        }
      </div>
      <Menu></Menu>
    </>
  )
}
