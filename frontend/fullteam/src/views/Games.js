import React, {useState} from 'react';
import List from '../components/List.js'
const Games = ({fetch}) => {

    return(
        <div className="gameRegister-container">
            <List fetch={fetch}/>
        </div>
    );
}

export default Games;