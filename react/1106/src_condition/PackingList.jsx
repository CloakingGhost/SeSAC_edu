function Item({ name, isPacked }) {
  if (isPacked) {
    return (
      <li className="item" style={{ color: "red" }}>
        {name} ✅
      </li>
    );
  }
  return (
    <li className="item" style={{ color: "blue" }}>
      {name}
    </li>
  );
}

// 삼항연산자
// function Item({ name, isPacked }) {
//   // return <li className="item">{isPacked ? `${name} ✅` : name}</li>;
//   return (
//     <>
//       {isPacked ? (
//         <li className="item" style={{ color: "red" }}>
//           {name} ✅
//         </li>
//       ) : (
//         <li className="item" style={{ color: "blue" }}>
//           {name}
//         </li>
//       )}
//     </>
//   );
// }

// function Item({ name, isPacked }) {
//   return <li className="item">{name} {isPacked && '✅'}</li>;
// }

export default function PackingList() {
  return (
    <section>
      <h1>Sally Ride's Packing List</h1>
      <ul>
        <Item isPacked={true} name="Space suit" />
        <Item isPacked={true} name="Helmet with a golden leaf" />
        <Item isPacked={false} name="Photo of Tam" />
      </ul>
    </section>
  );
}

const num = 10;
// 음수인지, 양수인지, 0인지를 변수에 저장하고 싶어.
// const state = (num === 0  ? '영이야' : (num < 0 ? '음수야' : '양수야'))

// let state
// if (num === 0){
//   state = '영이야'
// } else if (num < 0){
//   state  = '음수야'
// } else if (num > 0){
//   state = '양수야'
// }
