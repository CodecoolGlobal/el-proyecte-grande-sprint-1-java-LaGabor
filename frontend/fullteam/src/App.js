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
    useRef(false);

    return (
        <Router>
            <Switch>
                <Route exact path="/">
                    <Main/>
                </Route>
                <Route exact path="/games">
                    <Games/>
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
