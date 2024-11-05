import Header from './layout/frame/Header'
import Navigation from './layout/frame/Navigation'
import Main from './Main'
import Footer from './layout/frame/Footer'
import "./style.css"

export default function MySite() {
  return (
    <div className="container">
      <Header></Header>
      <Navigation></Navigation>
      <Main></Main>
      <Footer></Footer>
    </div>
  )
}
