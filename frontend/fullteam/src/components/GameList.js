import React, {useEffect, useState} from "react";

const GameList = ({fetch}) => {
    const [Games, setGames] = useState([]);


    useEffect(() => {
        fetch('http://localhost:8080/game/all-games', setGames);
    }, [])

    const getTableRows = (type) => {
        return Games.filter(g => g.type === type).map(game =>
            <tr>
                <td>{game.title}</td>
                <td>{game.minPlayer}</td>
                <td>{game.maxPlayer}</td>
                <td>{game.description}</td>
            </tr>
        )
    }
    return (
        <div className='gameListContainer'>
            <table className="gameTable">
                <tr>
                    <th>Title</th>
                    <th>Min</th>
                    <th>Max</th>
                    <th>Description</th>
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
export default GameList;


