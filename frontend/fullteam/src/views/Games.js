import React, {useState} from 'react';
import GameList from '../components/GameList.js'
const Games = ({fetch}) => {

    return(
        <div className="gameRegister-container">
            <GameList fetch={fetch}/>
        </div>
    );
}

export default Games;