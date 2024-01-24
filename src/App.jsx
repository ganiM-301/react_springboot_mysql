
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import {BrowserRouter as Router,Routes,Route} from 'react-router-dom'
import EmployeeComponent from './components/EmployeeComponent';
import ViewEmployeeComponent from './components/ViewEmployeeComponent';

function App() {

  return (
    <>
      <Router>
        <HeaderComponent/>
        <Routes>
          <Route path='/' element={<ListEmployeeComponent/>}></Route>
          <Route path='/employees' element={<ListEmployeeComponent/>}></Route>
          <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
          <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>
          <Route path='/view-employee/:id' element={<ViewEmployeeComponent/>}></Route>
        </Routes >
        <FooterComponent/>
      </Router>
    </>
  )
}

export default App
