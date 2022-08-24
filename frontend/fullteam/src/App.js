import React from 'react';
import {useEffect, useRef, useState} from "react";
import './App.css';
import Main from './views/Main.js'
import NotFound from './views/NotFound.js'
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Game from "./views/Game";
import GameRegister from "./views/GameRegister";
import Games from "./views/Games";
import Login from "./views/Login";
import Profile from "./views/Profile";
import TeamRegister from "./views/TeamRegister";
import Teams from "./views/Teams";
import Team from "./views/Team";
import Register from "./views/Register";


function App() {
    const [Game, setGame] = useState([]);
    let effectRan = useRef(false);

    const fetchUrl = (url, func, body = {}, method = 'POST') => {

            const requestOption = {
            method: method,
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(body)}


        console.log('In Fetch: ', requestOption.body)
        if (effectRan.current === true) {
            fetch(url, requestOption)
                .then(response => response.json())
                .then(res => {
                    func(res)
                    console.log(res)
                })
                .catch(error => {
                    console.error('There was an error!', error)
                });

        }
            effectRan.current = true
    }



    return (
        <Router>
            <Switch>
                <Route exact path="/">
                    <div>
                        <Main/>
                    </div>
                </Route>
                <Route exact path="/games">
                    <Games fetch={fetchUrl}/>
                </Route>
                <Route exact path="/game/register">
                    <GameRegister/>
                </Route>
                <Route path="/game/:id">
                    <Game/>
                </Route>
                <Route exact path="/login">
                    <Login/>
                </Route>
                <Route path="/profile/:id">
                    <Profile/>
                </Route>
                <Route exact path="/team/register">
                    <TeamRegister/>
                </Route>
                <Route exact path="/teams">
                    <Teams/>
                </Route>
                <Route path="/team/:id">
                    <Team/>
                </Route>
                <Route exact path="/register">
                    <Register/>
                </Route>
                <Route path="*">
                    <NotFound/>
                </Route>
            </Switch>
        </Router>
    );
}

export default App;
