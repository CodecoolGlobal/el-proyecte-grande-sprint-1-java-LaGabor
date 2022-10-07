import React from 'react';
import '../components/Login.css'
import { useHistory } from "react-router-dom";
import { useState } from "react";
import fetchUrl from "../fetch/fetch";


const Login = () => {
    const history = useHistory();
    const [user, setUser] = useState("");
    const [password, setPassword] = useState("");
    const [passW, setPassW] = useState("");
    const [userNameW, setUserNameW] = useState("");
    const [signup,setSignup] = useState("")
    const [signupE,setSignupE] = useState("")

    const userNotNull = () => {
        if(user.trim()===''){
            setUserNameW("Cant be Null!")
            return false;
        }
        setUserNameW("")
        return true;
    };

    const passwordNotNull = () => {
        if(password.trim()===""){
            setPassW("Cant be Null!")
            return false;
        }
        setPassW("")
        return true;
    };

    const redirectToMainPage = () =>{
        history.push('/')
    }

    async function fetchLoginUserData(){
        let body = {"username": user,
            "password": password
        }
        await fetchUrl.post("http://localhost:8080/login",body)
    };

    const signIn = async () => {
        let userNameIsNotNull= userNotNull();
        let passwordIsNotNull = passwordNotNull();
        if(userNameIsNotNull && passwordIsNotNull){
            let fetchValue = await fetchLoginUserData();
            console.log(fetchValue);
        }
        //history.push('/')
    }

    const register = () => {
        history.push('Register')
    }

    return (
        <div className="login">
            <div className="login__container">
                <div className="header">
                    <p className="success">{signup} </p>
                    <p className="notExist">{signupE}</p>
                </div>
                <h1>Sign-in</h1>
                    <h5>Username</h5>
                    <input
                        type="text"
                        value={user}
                        onChange={(e) => setUser(e.target.value)}
                    />
                    <p className="warnning">{userNameW}</p>

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






