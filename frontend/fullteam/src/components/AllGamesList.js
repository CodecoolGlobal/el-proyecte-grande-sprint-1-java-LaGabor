import React, {useEffect, useState} from "react";
import fetchUrl from "../fetch/fetch";
import {Link} from "react-router-dom";
import './Lister.css';

const AllGamesList = () => {
    const [Games, setGames] = useState([]);


    useEffect(() => {
        fetchUrl('http://localhost:8080/game/all-games', setGames);
    }, [])

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

    const getRandomPic = () => {
        const pics =["https://sayingimages.com/wp-content/uploads/calling-duck-meme.jpg","https://sayingimages.com/wp-content/uploads/no-matter-how-hard-you-try-duck-meme.jpg","https://i.redd.it/0ervpr0r2b681.jpg","https://www.askideas.com/media/40/Release-The-Quackin-Funny-Duck-Meme-Image.jpg" ]
        return pics[Math.floor(Math.random() * pics.length)]
    }

    const getGameList = () => {
        return Games.map((game,index) =>
            <div  className="row " key={index}>
                    <div className="data">
                        <div className="img flex">
                            <Link to={"/game/"+game.type.toLowerCase()+"/"+game.title} style={{ textDecoration: 'none' }}><img src={getRandomPic()} alt=""/></Link>
                        </div>
                        <div className="text">
                            {gameTypeBackground(game.type)}
                            <Link to={"/game/"+game.type.toLowerCase()+"/"+game.title } style={{ textDecoration: 'none' }}><p className="title">{game.title}</p></Link>
                            <div className="info">
                                <p>Required Team Members : {game.minPlayer} - {game.maxPlayer}</p>
                                <p>Creation Date : {game.creationDate}</p>
                            </div>
                        </div>
                    </div>
                    <div className="data">
                        <div className="city">
                            <p>{game.publisher}</p>
                            <hr/>
                            <p>{game.country}</p>
                        </div>
                        <div className="button">
                            <button>Own</button>
                        </div>
                    </div>
                </div>

        )
    }

    return (
        <div className="list-container">
            <div className="list-content .flex-column">
                {getGameList()}
            </div>
        </div>
    )

    }
export default AllGamesList;