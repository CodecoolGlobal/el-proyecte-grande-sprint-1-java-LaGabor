import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import fetchUrl from "../fetch/fetch";
const Team = () => {
    const {id} = useParams()
    const [Team, setTeam] = useState([]);
    const url = 'http://localhost:8080/team/' + id;

    useEffect( () => {
        fetchUrl(url).then(response => setTeam(response))
    }, [url])

    console.log("In team: ", Team)
    return(
        <div className="team-container">
            <h2>{Team.teamName}</h2>
        </div>
    );
}

export default Team;