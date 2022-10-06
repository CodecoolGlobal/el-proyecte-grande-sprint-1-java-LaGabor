import React, {useEffect, useState} from "react";
import fetchUrl from "../fetch/fetch";
import {Link} from "react-router-dom";

const OldAllGamesList = () => {
    const [Games, setGames] = useState([]);

    useEffect(() => {
        fetchUrl.get("http://localhost:8080/game/all-games").then(data => setGames(data));
    }, [])

    const getTableRows = (type) => {
        console.log(Games)
        return Games.filter(g => g.type === type).map(game =>
            <tr>
                <td><Link to={'/game/'+game.type.toLowerCase()+'/' + game.title}>{game.title}</Link></td>
                <td>{game.minPlayer} - {game.maxPlayer}</td>
                <td></td>
            </tr>
        )
    }
    return (
        <div className='gameListContainer'>
            <table className="gameTable">
                <tr>
                    <th>Title</th>
                    <th>Players</th>
                </tr>
                <p className='gameTableTypeName'>Online Games</p>
                {getTableRows('ONLINE')}
                <p className='gameTableTypeName'>Board Games</p>
                {getTableRows('BOARD')}
                <p className='gameTableTypeName'>Role Play Games</p>
                {getTableRows('RPG')}
            </table>
        </div>

    )
}
export default OldAllGamesList;


