import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import HelloWorld from './HelloWorld'
import FooterComponent from './components/FooterComponent'
import ListEmoloyeeComponent from './components/ListEmoloyeeComponent'
import HeaderComponent from './components/HeaderComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import EmployeeComponent from './components/EmployeeComponent'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path='/' element = {<ListEmoloyeeComponent />}></Route>
          <Route path='/employees' element = {<ListEmoloyeeComponent />}></Route>
          <Route path='/add-employee' element = {<EmployeeComponent />}></Route>
        </Routes>
        {/* <ListEmoloyeeComponent /> */}
        <FooterComponent />
      </BrowserRouter>

    </>
  )
}

export default App
