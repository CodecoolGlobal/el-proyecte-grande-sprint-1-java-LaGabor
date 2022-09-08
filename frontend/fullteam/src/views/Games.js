import React from 'react';
import OldAllGamesList from '../components/OldAllGamesList.js'
import PageTitle from "../components/PageTitle";
import AllGamesList from "../components/AllGamesList";
import '../components/Lister.css';
const Games = () => {

    return(
        <div className="gameRegister-container">
            <AllGamesList/>
        </div>
    );
}

export default Games;