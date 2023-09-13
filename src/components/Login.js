import React, { useState } from 'react'
import '../styles/Login.css'
import AuthenticationService from '../service/AuthenticationService';
import { useNavigate } from 'react-router-dom';

const Login = () => {

    //define state with setter methods using useState() hook

    const history = useNavigate();
    const [email,setEmail] = useState('');
    const [password,setPassword] = useState('');
    const [errorMessage,setErrorMessage] = useState('');
    const [successMessage,setSuccessMessage] = useState('');


    //Method to login
    const handleLogin = async () => {
        if(!email || !password){
            setErrorMessage('Please Enter both Email or Password.')
            return;
        }

        const dealer={email,password};
        try{
            const loginSuccess = await AuthenticationService.login(dealer);
            console.log('API response :',loginSuccess.data);

            if(loginSuccess){
                setSuccessMessage('Login Successfull. Redirecting .....');

              setTimeout(() => {
                history('/product');
              }, 200);
            }else{
                setErrorMessage('Invalid Email or Password');
            }
        }
        catch(error){
            console.log('Login Error : ', error)
            setErrorMessage('Error Occured during Login');        
        }
    }

  return (
    <div> <br/><br/>
    <div className='container'>
        <h2 style={{color:"green"}}>Dealer Login</h2>
        <div className='form-group'>
           <label>Email : </label> 
           <input type="email" className='form-control' value={email} onChange={(e) => setEmail(e.target.value)}/>
        </div>
        <div className='form-group'>
           <label>Password : </label> 
           <input type="password" className='form-control' value={password} onChange={(e) => setPassword(e.target.value)}/>
        </div>
        <button className='btn btn-primary' onClick={handleLogin}>Login</button>
        {errorMessage && <p className='error-message'>{errorMessage}</p>}
        {successMessage && <p className='success-message'>{successMessage}</p>}
    </div>
    </div>
  )
}

export default Login