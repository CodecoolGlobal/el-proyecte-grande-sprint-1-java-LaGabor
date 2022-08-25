import React from 'react';
import AllGamesList from '../components/allGamesList.js'
import PageTitle from "../components/PageTitle";
const Games = () => {

    return(
        <div className="gameRegister-container">
            <PageTitle title='All Games Yet We Have.'/>
            <AllGamesList/>
        </div>
    );
}

export default Games;