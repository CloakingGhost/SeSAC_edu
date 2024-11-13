import { lazy, Suspense } from 'react';
// import UserPage from "./UserPage"
// import AdminPage from "./AdminPage"
// import ManagerPage from "./ManagerPage"
// import GuestPage from "./GuestPage"
import Error404 from "./Error404"
import React from "react"
const AdminPage = lazy(() => import('./AdminPage'));
const ManagerPage = lazy(() => import('./ManagerPage'));
const UserPage = lazy(() => import('./UserPage'));
const GuestPage = lazy(() => import('./GuestPage'));

/**
 * @param {string} userType 
 */

export default function Page({ userType }) {
  const myApp = <h2>나의 앱</h2>
  if (userType === "admin") {
    return (
      <>
        {myApp}
        <AdminPage></AdminPage>
      </>)
  } else if (userType === "manager") {
    return (
      <>
        {myApp}
        <ManagerPage></ManagerPage>
      </>)
  } else if (userType === "user") {
    return (
      <>
        {myApp}
        <UserPage></UserPage>
      </>)
  }
  return (<>
    {myApp}
    <GuestPage></GuestPage>
  </>)
}



// export default function Page({ userType }) {

//   let renderedPage;
//   if (userType === "admin") {
//     renderedPage = <AdminPage></AdminPage>
//   } else if (userType === "manager") {
//     renderedPage = <ManagerPage></ManagerPage>
//   } else if (userType === "user") {
//     renderedPage = <UserPage></UserPage>
//   } else if (userType === "guest") {
//     renderedPage = <GuestPage></GuestPage>
//   } else {
//     return <Error404></Error404>
//   }
//   return (
//     <>
//       <h2>나의 앱</h2>
//       {renderedPage}
//     </>
//   )
// }

// export default function Page({ userType }) {
//   const mappingPage = {
//     admin: <AdminPage></AdminPage>,
//     manager: <ManagerPage></ManagerPage>,
//     user: <UserPage></UserPage>,
//     guest: <GuestPage></GuestPage>
//   }
//   let renderedPage = mappingPage[userType];
//   // React.lazy(()=> import("./Error404"))
//   if (!renderedPage) {
//     return <Error404></Error404>
//   }
//   return (
//     <>
//       <h2>나의 앱</h2>
//       {renderedPage}
//     </>
//   )
// }


export default function Page({ userType }) {
  const mappingPage = {
    admin: <AdminPage />,
    manager: <ManagerPage />,
    user: <UserPage />,
    guest: <GuestPage />
  };
  let renderedPage = mappingPage[userType];
  if (!renderedPage) {
    return <Error404></Error404>
  }
  return (
    <Suspense fallback={<div>Loading...</div>}>
      <h2>나의 앱</h2>

      {renderedPage}
    </Suspense>
  )
}