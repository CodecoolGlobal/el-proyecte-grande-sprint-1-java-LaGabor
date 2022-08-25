import React from 'react';
import '../components/Login.css'
import { Link, useHistory } from "react-router-dom";
import { useState } from "react";


const Login = () => {
    const history = useHistory();
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const signIn = () => {
        history.push('/')

    }

    const register = () => {
        history.push('Register')
    }

    return (
        <div className="login">
            <div className="login__container">
                <h1>Sign-in</h1>

                <form>
                    <h5>E-mail</h5>
                    <input
                        type="text"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />

                    <h5>Password</h5>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />

                    <button
                        type="submit"
                        onClick={signIn}
                        className="login__signInButton"
                    >
                        Sign In
                    </button>
                </form>

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






