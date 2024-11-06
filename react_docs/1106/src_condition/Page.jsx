import AdminPage from "./AdminPage";
import UserPage from "./UserPage";

// export default function Page() {
//   const isAdmin = false; // false

//   if (isAdmin) {
//     return (
//       <>
//         <h1>나의 어플</h1>
//         <AdminPage></AdminPage>
//       </>
//     );
//   }

//   return (
//     <>
//       <h1>나의 앱</h1>
//       <UserPage></UserPage>
//     </>
//   );
// }

//////////////////////////////////////////////////////////////////////////////|

// export default function Page() {
//   const isAdmin = true; // false

//   let renderedPage;

//   if (isAdmin) {
//     renderedPage = <AdminPage></AdminPage>;
//   } else {
//     renderedPage = <UserPage></UserPage>;
//   }

//   const renderedPage_2 = isAdmin ? (
//     <AdminPage></AdminPage>
//   ) : (
//     <UserPage></UserPage>
//   );

//   return (
//     <>
//       <h1>나의 앱</h1>
//       {renderedPage}
//       {renderedPage_2}
//     </>
//   );
// }

//////////////////////////////////////////////////////////////////////////////|

export default function Page() {
  const isAdmin = false; // false
  return (
    <>
      <h1>나의 앱</h1>
      {isAdmin ? <AdminPage></AdminPage> : <UserPage></UserPage>}
    </>
  );
}
