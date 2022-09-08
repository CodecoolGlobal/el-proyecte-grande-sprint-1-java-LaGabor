import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import PageTitle from "../components/PageTitle";
import fetchUrl from "../fetch/fetch";
import GameDescription from "../components/gameDescription";

const Game = () => {
    const {id} = useParams();
    const [game, setGame] = useState([])
    const url = 'http://localhost:8080/game/' + id;

    useEffect( () => {
         fetchUrl(url).then(data => setGame(data));
    }, [url])


    return (
        <div className="game-container">
            <PageTitle title={game.title}/>
            <GameDescription game={game}/>
        </div>
    );
}

export default Game;