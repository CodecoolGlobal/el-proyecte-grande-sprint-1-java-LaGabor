import React, {useState} from 'react';
import GameList from '../components/GameList.js'
import PageTitle from "../components/PageTitle";
const Games = ({fetch}) => {

    return(
        <div className="gameRegister-container">
            <PageTitle title='All Games Yet We Have.'/>
            <GameList fetch={fetch}/>
        </div>
    );
}

export default Games;