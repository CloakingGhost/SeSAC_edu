import Welcome from "./assets/Welcome";
import Card from "./assets/Card";
import Button from "./assets/Button";
function App() {
  const whiteColor = "#fff";


const realArr = [
  {text : '취소', color : 'tomato'},
  {text : '확인', color : 'blue'},
  {text : '보류', color : 'gray'},
  {text : '1억년', color : 'pink'},
]
const newArr = realArr.map(el=><Button content={el.text} backgroundColor={el.color} color={whiteColor}/>)

  return (
    <div>
      App

      <Welcome name={"아따 반갑소"} />
      <Card
        width={400}
        height={200}
        title={"제목이다"}
        content={"내용이다"}
      />
      {newArr}
      {/* <Button content={} backgroundColor={} color={whiteColor}/>
      <Button content={} backgroundColor={} color={whiteColor}/>
      <Button content={} backgroundColor={} color={whiteColor}/>
      <Button content={} backgroundColor={} color={whiteColor}/> */}
    </div>
  );
}

export default App;
