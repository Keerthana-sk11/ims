import logo from './logo.svg';
import './App.css';
import NavBar from './components/NavBar';

import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Registration from './components/Registration';
import Login from './components/Login';
import Product from './components/Product';

/*
	React Router is a standard library for routing in React. 
	It enables the navigation among views of various components in a React Application, 
  allows changing the browser URL, and keeps the UI in sync with the URL. 

	React Router is a JavaScript framework that lets us handle client and server-side 
  routing in React applications. 
  It enables the creation of single-page web or mobile apps that allow navigating without 
  refreshing the page. 
  It also allows us to use browser history features while preserving the right application
   view.

   Used Version6 of Router

 > npm install react-router-dom --save
*/

/*To use the Font-awesome, install all given packages from npm into your app.

npm i --save @fortawesome/fontawesome-svg-core
npm i --save @fortawesome/free-solid-svg-icons
npm i --save @fortawesome/react-fontawesome

 * And import the library for the font-awesome

*/

import {library} from '@fortawesome/fontawesome-svg-core';
import {faSignIn,faCameraRetro} from '@fortawesome/free-solid-svg-icons';
library.add(faSignIn,faCameraRetro);

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>INVENTORY MANAGEMENT SYSTEM</h1>
      </header>

      <section>
        <div style={{ backgroundImage:"url(/images/bg1.jpg)",
         backgroundSize:"cover", backgroundRepeat:"no-repeat", minHeight:"100vh", minWidth:"70vw"}}>

        <Router>
          <NavBar/> {/* Render NavBar Component */}

          <Routes>
              <Route path='/register' element={<Registration/>}/>
              <Route path='/login' element={<Login/>}/>

              <Route path='/product' element={<Product/>}/>
          </Routes>
        </Router>
        </div>
      </section>

      <footer className='footer'>
        <p>&copy; All rights reserved to Wells Fargo</p>
      </footer>

    </div>
  );
}

export default App;
