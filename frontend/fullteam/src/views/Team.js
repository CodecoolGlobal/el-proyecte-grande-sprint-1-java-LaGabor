import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import get from "../fetch/fetch";
import TeamCard from "../components/Card";
const Team = () => {
    return(
        <div className="team-container">
            <TeamCard />
        </div>
    );
}

export default Team;