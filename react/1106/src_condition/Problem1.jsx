import React from "react";

// export default function Problem1() {
//   // 로그인 여부에 따라
//   // 다른 text를 보여주자.

//   const isLoggedIn = false;

//   if (isLoggedIn) {
//     return <h3>환영합니다!</h3>;
//   } else {
//     return <div style={{ color: "red" }}>로그인이 필요합니다</div>;
//   }
// }
export default function Problem1() {
  // 로그인 여부에 따라
  // 다른 text를 보여주자.

  const isLoggedIn = false;
  let result;
  if (isLoggedIn) {
    result = <h3>환영합니다!</h3>;
  } else {
    result = <div style={{ color: "red" }}>로그인이 필요합니다</div>;
  }

  return result;
}

// export default function Problem1() {
//   const isLoggedIn = true;

//   return (
//     <>
//       {isLoggedIn ? (
//         <h3>환영합니다!</h3>
//       ) : (
//         <div style={{ color: "red" }}>로그인이 필요합니다</div>
//       )}
//     </>
//   );
// }

// export default function Problem1() {
//   const isLoggedIn = true;

//   return (
//     <>
//       {isLoggedIn && <div>환영합니다!</div>}
//       {!isLoggedIn && <div>로그인이 필요합니다!</div>}
//     </>
//   );
// }
