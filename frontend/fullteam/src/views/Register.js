import React from 'react';
import '../components/Register.css'
import { useState, useEffect } from "react";
const Register = () => {
    const BASE_URL = "https://jsonplaceholder.typicode.com/users";
    const [name, setName] = useState("");
    const [nameW, setNameW] = useState("");
    const [email, setEmail] = useState("example@email.com");
    const [emailW, setEmailW] = useState("");
    const [password, setPassword] = useState("");
    const [passwordW, setPasswordW] = useState("");
    const [confirmPwd, setConfirmPwd] = useState("");
    const [confirmPwdW, setConfirmPwdW] = useState("");
    const [fname, setFname] = useState("");
    const [lname, setLname] = useState("");
    const [fullname, setFullname] = useState("d");
    const [fullnameW, setFullnameW] = useState("");
    const [checkbox, setCheckbox] = useState(false);
    const [signup, setSignup] = useState("");
    const [date, setDate] = useState("");
    useEffect(() => {
        confirmPwdChecking();
        EmailChecking();
        NameChecking();

        fullnameChecking();
    }, [confirmPwd, email, name, lname, fname]);
    const NameChecking = () => {
        if (name === "Recoded" || name === "recoded") {
            setNameW("Username is taken ");
            return false;
        } else {
            setNameW("");
            return true;
        }
    };
    const EmailChecking = () => {
        if (!email.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i)) {
            setEmailW("invalid Email");
            return false;
        } else {
            setEmailW("");
            return true;
        }
    };
    const PassChecking = () => {
        if (password.length < 5) {
            setPasswordW("pasword should be at least 6 characters ");
            return false;
        } else {
            setPasswordW("");
            return true;
        }
    };
    const confirmPwdChecking = () => {
        if (password !== confirmPwd) {
            setConfirmPwdW(" Password doesn't match");
            return false;
        } else {
            setConfirmPwdW("");
            return true;
        }
    };

    const fullnameChecking = () => {
        setFullname(fname + lname);
        if (!fullname.match(/^[a-zA-Z ]+$/)) {
            setFullnameW("Name only accepts letters");

            return false;
        } else {
            setFullnameW("");
            return true;
        }
    };

    const birthDateChecking = () => {
        if (date){
            return true;
        }
        return false;
    };

    function handleSubmit(e) {
        NameChecking();
        EmailChecking();
        PassChecking();
        confirmPwdChecking();
        fullnameChecking();
        birthDateChecking()
        if (
            fullnameChecking() === true &&
            confirmPwdChecking() === true &&
            PassChecking() === true &&
            EmailChecking() === true &&
            NameChecking() === true &&
            birthDateChecking() === true &&
            checkbox === true
        ) {
            fetchData();
        } else if (
            fullnameChecking() === true &&
            confirmPwdChecking() === true &&
            PassChecking() === true &&
            EmailChecking() === true &&
            NameChecking() === true &&
            checkbox === false
        ) {
            alert("please accept terms of service");
        } else {
            alert("please fill in the from");
        }
    }

    const fetchData = () => {
        fetch(BASE_URL, {
            method: "POST",
            body: JSON.stringify({
                name: fullname,
                username: name,
                email: email,
                password: password
            }),
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then((res) => {
                return res.json();
            })
            .then((json) => {
                console.log(json);
                setSignup("Successfully signed up");
            })
            .catch((e) => {
                console.log(e);
            });
    };

    return (
        <div className="main-container">
            <div className="form">
                <div className="header">
                    <p className="success">{signup} </p>
                    <h1>Registration form </h1>
                </div>

                <form>
                    {" "}
                    <div className="inputs">
                        <input
                            type="text"
                            id="username"
                            placeholder="username"
                            pattern="[a-zA-Z][a-zA-Z ]{2,}"
                            onChange={(event) => setName(event.target.value)}
                        />
                        <i class="fa fa-user icon"></i>
                        <p className="warnning">{nameW}</p>
                    </div>
                    <div className="inputs">
                        <input
                            type="email"
                            id="email"
                            placeholder="Email address"
                            onChange={(event) => setEmail(event.target.value)}
                        />

                        <i class="fa fa-envelope icon"></i>
                        <p className="warnning">{emailW}</p>
                    </div>


                    <div className="inputs">
                        <input type="date" id="birthday" name="birthday" onChange={(event) => setDate(event.target.value)} />
                    </div>




                    <div className="inputs">
                        <input
                            type="password"
                            id="password"
                            placeholder="password"
                            onChange={(event) => {
                                setPassword(event.target.value);
                                PassChecking(event.target.value);
                            }}
                        />
                        <i class="fa fa-unlock-alt icon"></i>
                        <p className="warnning">{passwordW}</p>
                    </div>
                    <div className="inputs">
                        <input
                            type="password"
                            id="confirm-password"
                            placeholder="confirm password"
                            onChange={(event) => setConfirmPwd(event.target.value)}
                        />
                        <i class="fa fa-unlock-alt icon"></i>
                        <p className="warnning">{confirmPwdW}</p>
                    </div>
                    <div>
                        <div>
                            <div className="inputs name-inputs">
                                <input
                                    type="text"
                                    id="fname"
                                    placeholder="First name"
                                    onChange={(event) => {
                                        setFname(event.target.value);
                                    }}
                                />
                                <input
                                    type="text"
                                    id="lname"
                                    placeholder="last name"
                                    onChange={(event) => {
                                        setLname(event.target.value);
                                    }}
                                />
                            </div>
                            <p className="warnning name-warnning">{fullnameW}</p>
                            <br />
                            <div className="checkbox">
                                <input
                                    type="checkbox"
                                    id="terms"
                                    onChange={() => setCheckbox(!checkbox)}
                                />
                                <label for="checkbox"> I agree to selling my soul.</label>
                            </div>
                            <br />
                        </div>
                        <div>
                            <button type="button" id="submit-btn" onClick={handleSubmit}>
                                Sign Up
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default Register;





