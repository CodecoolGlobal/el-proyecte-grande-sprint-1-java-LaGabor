import React, {useState} from 'react';
import AllGamesList from "../components/AllGamesList";
import '../components/Lister.css';
import {useEffectOnce} from "../hook/useEffectOnce";
import fetchUrl from "../fetch/fetch";
const Games = () => {
    const [games, setGames] = useState([]);

    useEffectOnce(() => {
        fetchUrl.get("http://localhost:8080/games")
            .then(data => setGames(data))
    })

    return games && (
        <div className="gameRegister-container">
            <AllGamesList games={games}/>
        </div>
    );
}

export default Games;