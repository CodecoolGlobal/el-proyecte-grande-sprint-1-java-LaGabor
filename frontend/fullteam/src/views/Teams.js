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

    const getRandomPic = () => {
        const pics =["https://i.pinimg.com/236x/3e/17/1a/3e171aae4436f38ad9b02f98ff37cb98--funny-duck-flash-drive.jpg","http://www.dumpaday.com/wp-content/uploads/2016/09/funny-duck.jpg","https://i5.walmartimages.com/asr/ecdcbf1d-3c09-430d-a33e-aa2b5358d5d5.7dbf2b7c5957f63c53ac4b902447e703.jpeg"]
        return pics[Math.floor(Math.random() * pics.length)]
    }

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
                        <img src={getRandomPic()} alt=""/>
                    </div>
                    <div className="text">
                        {gameTypeBackground(team.game.type)}
                        <Link to={"/team/" + team.teamName}
                              style={{textDecoration: 'none'}}><p className="title">{team.teamName}</p></Link>
                        <div className="info">
                            <p>Required Team Members : {team.minWantedTeamSize} - {team.maxWantedTeamSize}</p>
                            <p>Admin : {team.admin.username}</p>
                            <p>Team Created : {team.teamCreated}</p>
                        </div>
                    </div>
                </div>
                <div className="data">
                    <div className="city">
                        <p> Free Space : {team.freePlaces}</p>
                        <hr/>
                        <Link to={"/game/"+team.game.type.toLowerCase()+"/"+team.game.title } style={{ textDecoration: 'none' }}><p className="title">{team.game.title}</p></Link>
                    </div>
                    <div className="button">
                        <button>Checkout</button>
                    </div>
                </div>
            </div>
        )
    }

    return teams && (
        <div className="gameRegister-container">
            <div className="list-container">
                <div className="list-content .flex-column">
                    {putOutTeams()}
                </div>
            </div>
        </div>
    );
}

export default Teams;