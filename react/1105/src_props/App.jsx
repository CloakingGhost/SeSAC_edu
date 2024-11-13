import Profile from "./Profile";
import Article from "./Article";
import Welcome from "./Welcome";
import Card from "./Card";
import Button from "./Button";
import CancleButton from "./CancleButton";
import Container from "./Container";

function App() {
  return (
    <>
      <Container>
        <CancleButton>취소</CancleButton>
      </Container>
      <Container>
        <Card
          title="제목123"
          content="내용123"
          style={{
            width: 100,
            height: 100,
          }}
        ></Card>
      </Container>

      <CancleButton>금지</CancleButton>
      <CancleButton>하지마</CancleButton>
      <Button backgroundColor="blue" text="확인" color="red"></Button>
      <Button backgroundColor="red" text="취소"></Button>
      <Button backgroundColor="gray" text="보류"></Button>
      <Button backgroundColor="pink" text="1억년"></Button>
      {/* 
      <Card
        content="내용453"
        style={{
          width: 200,
          height: 100,
        }}
      ></Card> */}

      {/* <Welcome name={"정우영"}></Welcome>
      <Welcome name={"최혜미"}></Welcome>
      <Welcome name={"반장님"}></Welcome>
      <Welcome name={"머시깽이"}></Welcome>

      <Profile
        person={{
          name: "Lin Lanying",
          imgUrl: "https://i.imgur.com/YfeOqp2.jpg",
        }}
        size={100}
      ></Profile>
      <div>
        <Article title={"제목1"} content={"내용1"}></Article>
        <Article title={"제목2"} content={"내용2"}></Article>
        <Article title={"제목3"} content={"내용3"}></Article>
      </div> */}
    </>
  );
}

export default App;
