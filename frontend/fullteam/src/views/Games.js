import React, {useState} from 'react';
import GameList from '../components/GameList.js'
import PageTitle from "../components/PageTitle";
const Games = () => {

    return(
        <div className="gameRegister-container">
            <PageTitle title='All Games Yet We Have.'/>
            <GameList/>
        </div>
    );
}

export default Games;