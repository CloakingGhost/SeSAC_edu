import AdminPage from "./AdminPage";
import UserPage from "./UserPage";
import MangerPage from "./MangerPage";
// import { isNull } from "lodash";

// export default function OtherPage() {
//   // const userType = "admin";
//   // const userType = "manager";
//   const userType = "user";
//   let renderedPage;
//   if (userType === "admin") {
//     renderedPage = <AdminPage></AdminPage>;
//   } else if (userType === "manager") {
//     renderedPage = <MangerPage></MangerPage>;
//   } else if (userType === "user") {
//     renderedPage = <UserPage></UserPage>;
//   }
//   // else if (isNull(userType)) {
//   //   renderedPage = null;
//   // }

//   return (
//     <>
//       <h1>나의 앱</h1>
//       {renderedPage}
//     </>
//   );
// }

// export default function OtherPage() {
//   // const userType = "admin";
//   const userType = "manager";
//   // const userType = "user";
//   const renderedPage =
//     userType === "admin" ? (
//       <AdminPage>
//         <div></div>
//       </AdminPage>
//     ) : userType === "manager" ? (
//       <MangerPage></MangerPage>
//     ) : (
//       <UserPage></UserPage>
//     );

//   return (
//     <>
//       <h1>나의 앱</h1>
//       {renderedPage}
//     </>
//   );
// }

export default function OtherPage() {
  // const userType = "admin";
  const userType = "manager";
  // const userType = "user";

  const mappingPage = {
    admin: <AdminPage></AdminPage>,
    manager: <MangerPage></MangerPage>,
    user: <UserPage></UserPage>,
  };
  const renderedPage = mappingPage[userType];

  return (
    <>
      <h1>나의 앱</h1>
      {renderedPage}
    </>
  );
}
