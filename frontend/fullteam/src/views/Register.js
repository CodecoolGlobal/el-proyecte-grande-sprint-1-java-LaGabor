import React from 'react';
import '../components/Register.css'
import { useState, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import get from "../fetch/fetch";
import fetchUrl from "../fetch/fetch";
const Register = () => {
    let wrongSign = false;
    const history = useHistory();
    const BASE_URL = "https://jsonplaceholder.typicode.com/users";
    const [name, setName] = useState("");
    const [nameW, setNameW] = useState("");
    const [email, setEmail] = useState("");
    const [emailW, setEmailW] = useState("");
    const [password, setPassword] = useState("");
    const [passwordW, setPasswordW] = useState("");
    const [confirmPwd, setConfirmPwd] = useState("");
    const [confirmPwdW, setConfirmPwdW] = useState("");
    const [fName, setFName] = useState("");
    const [lName, setLName] = useState("");
    const [fullname, setFullname] = useState("");
    const [fullnameW, setFullnameW] = useState("");
    const [checkbox, setCheckbox] = useState(false);
    const [signup, setSignup] = useState("");
    const [signupE, setSignupE] = useState("");
    const [checkboxWarning,setCheckboxWarning] = useState("");
    const [date, setDate] = useState("");
    const [dateW, setDateW] = useState("");
    useEffect(() => {
        confirmPwdChecking();
        emailChecking();
        nameChecking();
        fullnameChecking();
    }, [confirmPwd, email, name, lName, fName,checkbox]);
    const nameChecking = () => {
        if(name.trim().length === 0){
            if(wrongSign){
                setNameW("Name cant be Null!");
            }
            return false;
        }
        if (name === "Recoded" || name === "recoded") {
            setNameW("Username is taken ");
            return false;
        } else {
            setNameW("");
            return true;
        }
    };
    const emailChecking = () => {
        if (!email.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i)) {
           if(email.trim()===''){
               if(wrongSign){
                   setEmailW("CantBeNull")}else{
                   setEmailW("")
               }
               return false}
            setEmailW("invalid Email")
            return false
        } else {
            setEmailW("");
            return true;
        }
    };
    const PasswordLengthChecking = () => {
        if (password.length < 5) {
            setPasswordW("password should be at least 6 characters ");
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
        setFullname(fName + lName);
        if(fullname === ""){

            return false;
        }
        if (!fullname.match(/^[a-zA-Z ]+$/)) {
            setFullnameW("Name only accepts letters");

            return false;
        } else {
            setFullnameW("");
            return true;

        }
    };

    const birthDateChecking = () => {
        if (Date.parse(date)<Date.now()){
            setDateW("")
            return true;
        }
        if(!date){
           setDateW("Cant be Null!")
            return  false;
        }
        setDateW("Are you from the future?")
        return false;
    };

    const checkboxChecking = () =>{
        if(checkbox === true){
            setCheckboxWarning("")
            return true;
        }else{
            setCheckboxWarning("You need to sell Your Soul!")
            return false
        }
    }

    async function handleSubmit(e) {
        let nameCheck = nameChecking();
        let emailCheck = emailChecking();
        let passwordLengthCheck = PasswordLengthChecking();
        let passwordCheck = confirmPwdChecking();
        let fullNameCheck = fullnameChecking();
        let birthdateCheck = birthDateChecking()
        let checkboxCheck = checkboxChecking()
        if (
            fullNameCheck === true &&
            passwordCheck === true &&
            passwordCheck === true &&
            emailCheck === true &&
            nameCheck === true &&
            birthdateCheck === true &&
            checkboxCheck === true &&
            await checkIfNameExist(name) === true &&
            await checkIfEmailExist(email) === true
        ) {
            fetchUserData();
        } else if (
            fullNameCheck === true &&
            passwordCheck === true &&
            passwordLengthCheck === true &&
            emailCheck === true &&
            nameCheck === true &&
            checkboxCheck === false
        ) {
            wrongSign = true;
            nameChecking();
            emailChecking()
            alert("please accept terms of service");
        } else {
            wrongSign = true;
            nameChecking();
            emailChecking()
            alert("please fill in the from");
        }
    }

    const redirectToMainPage = () =>{
        history.push('/')
    }

    async function fetchUserData(){
        let body = {"username": name,
                    "email": email,
                    "birthDate": date,
                    "password": password
                    }
        await fetchUrl.post("http://localhost:8080/authentication/create/profile",body)
                setSignup("Successfully signed up");
                setSignupE("");
                setTimeout(redirectToMainPage,1000);

    };

    async function checkIfNameExist(name) {
        let profileNameExistCheck = await fetchUrl.get(`http://localhost:8080/authentication/check/profile/${name}`);
        if(!profileNameExistCheck){
            return true;
        }
        setSignupE("Username already exist!");
        setSignup("");
        return false;
    }

    async function checkIfEmailExist(email) {
        let emailExistCheck = await fetchUrl.get(`http://localhost:8080/authentication/check/email/${email}`);
        if(!emailExistCheck){
            return true;
        }
        setSignupE("Email already exist!");
        setSignup("");
        return false;
    }

    return (
        <div className="main-container">
            <div className="form">
                <div className="header">
                    <p className="success">{signup} </p>
                    <p className="exist">{signupE}</p>
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
                        <p className="warnning">{dateW}</p>
                    </div>

                    <div className="inputs">
                        <input
                            type="password"
                            id="password"
                            placeholder="password"
                            onChange={(event) => {
                                setPassword(event.target.value);
                                PasswordLengthChecking(event.target.value);
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
                                        setFName(event.target.value);
                                    }}
                                />
                                <input
                                    type="text"
                                    id="lname"
                                    placeholder="last name"
                                    onChange={(event) => {
                                        setLName(event.target.value);
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
                                <p className="warnning">{checkboxWarning}</p>
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





