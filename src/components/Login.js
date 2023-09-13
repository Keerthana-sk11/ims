import React from 'react'
import '../styles/Login.css'

const Login = () => {
  return (
    <div> <br/><br/>
    <div className='container'>
        <h2 style={{color:"green"}}>Dealer Login</h2>
        <div className='form-group'>
           <label>Email : </label> 
           <input type="email" className='form-control'/>
        </div>
        <div className='form-group'>
           <label>Password : </label> 
           <input type="password" className='form-control'/>
        </div>
        <button className='btn btn-primary'>Login</button>
    </div>
    </div>
  )
}

export default Login