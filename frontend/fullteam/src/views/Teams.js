import React, {useState} from 'react';
import {Link, useParams} from "react-router-dom";
import {useEffectOnce} from "../hook/useEffectOnce";
import fetchUrl from "../fetch/fetch";
import "../components/Lister.css";

const Teams = () => {
    const {gameType} = useParams();
    const [teams, setTeams] = useState([]);

    useEffectOnce(() => {
        console.log(gameType)
        fetchUrl.get("http://localhost:8080/team/" + gameType.toUpperCase() + "/all-teams")
            .then(data => setTeams(data));
    })

    const gameTypeBackground = gameType =>{
        if(gameType==="BOARD"){
            return (
                <p className="statue" style={{backgroundColor: 'green',}}>{gameType}</p>
            )
        }else if(gameType==="ONLINE"){
            return (
                <p className="statue" style={{backgroundColor: 'purple',}}>{gameType}</p>
            )
        }else{
            return (
                <p className="statue" style={{backgroundColor: 'orange',}}>{gameType}</p>
            )
        }
    }

    function putOutTeams() {
        return teams.map((team, index) =>
            <div className="row " key={index}>
                <div className="data">
                    <div className="img flex">
                        <Link to={"/game/"+game.type.toLowerCase()+"/"+game.title} style={{ textDecoration: 'none' }}><img src={getRandomPic()} alt=""/></Link>
                    </div>
                    <div className="text">
                        {gameTypeBackground(gameType)}
                        <Link to={"/team/" + team.teamName}
                              style={{textDecoration: 'none'}}><p className="title">{team.teamName}</p></Link>
                        <div className="info">
                            <p>Required Team Members : {team.minWantedTeamSize} - {team.maxWantedTeamSize}</p>
                            <p>Creation Date : {team.teamCreated}</p>
                            <p>Description: {team.description}</p>
                        </div>
                    </div>
                </div>
                <div className="data">
                    <div className="city">
                        <p>{team.admin.username}</p>
                        <hr/>
                        {team.players.map(player => <p>{player.username}</p>)}
                    </div>
                    <div className="button">
                        <button>Own</button>
                    </div>
                </div>
            </div>
        )
    }

    return teams && (
        <div className="team-container">
            <h2>I am the Team List Page! </h2>
            <div className="list-content .flex-column">
                {putOutTeams()}
            </div>
        </div>
    );
}

export default Teams;