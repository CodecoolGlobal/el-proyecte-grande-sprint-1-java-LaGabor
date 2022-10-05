import React from 'react';
import '../components/Login.css'
import { useHistory } from "react-router-dom";
import { useState } from "react";


const Login = () => {
    const history = useHistory();
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [passW, setPassW] = useState("");
    const [emailW, setEmailW] = useState("");
    const [signup,setSignup] = useState("")
    const [signupE,setSignupE] = useState("")

    const signIn = () => {
        let emailIsNotNull= emailNotNull();
        let passwordIsNotNull = passwordNotNull();
        if(emailIsNotNull && passwordIsNotNull){

        }
        //history.push('/')
    }

    const register = () => {
        history.push('Register')
    }

    const emailNotNull = () => {
        if(email.trim()===''){
            setEmailW("Cant be Null!")
            return false;
        }
        return true;
    };

    const passwordNotNull = () => {
        if(email.trim()===''){
            setPassW("Cant be Null!")
            return false;
        }
        return true;
    };


    return (
        <div className="login">
            <div className="login__container">
                <div className="header">
                    <p className="success">{signup} </p>
                    <p className="notExist">{signupE}</p>
                    <h1>Registration form </h1>
                </div>
                <h1>Sign-in</h1>
                    <h5>E-mail</h5>
                    <input
                        type="text"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <p className="warnning">{emailW}</p>

                    <h5>Password</h5>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <p className="warnning">{passW}</p>

                    <button
                        type="submit"
                        onClick={signIn}
                        className="login__signInButton"
                    >
                        Sign In
                    </button>
                <p>
                    By signing-in you agree to selling your soul for the FullTeam Corp.
                </p>

                <button className="login__registerButton" onClick={register}>
                    Create your TeamMaker Account
                </button>
            </div>
        </div>
    );
}
export default Login;






