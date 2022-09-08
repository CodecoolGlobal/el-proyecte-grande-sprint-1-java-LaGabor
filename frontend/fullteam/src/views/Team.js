import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import fetchUrl from "../fetch/fetch";
import TeamCard from "../components/teamCard";
const Team = () => {
    return(
        <div className="team-container">
            <TeamCard />
        </div>
    );
}

export default Team;