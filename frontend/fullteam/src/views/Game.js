import React, {useState} from 'react';
import {useParams} from "react-router-dom";
import PageTitle from "../components/PageTitle";
import fetchUrl from "../fetch/fetch";
import GameDescription from "../components/gameDescription";
import {useEffectOnce} from "../hook/useEffectOnce";

const Game = () => {
    const {type,title} = useParams();
    const [game, setGame] = useState([])
    const url = 'http://localhost:8080/game/' + type.toUpperCase() + '/'+ title;
    console.log('In Game', url)

    useEffectOnce( () => {
         fetchUrl.get(url).then(data => setGame(data))})

    return game && (
        <div className="game-container">
            <PageTitle title={game.title}/>
            <GameDescription game={game}/>
        </div>
    );
}

export default Game;