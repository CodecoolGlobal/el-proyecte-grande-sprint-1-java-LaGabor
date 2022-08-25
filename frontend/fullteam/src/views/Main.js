import React from 'react';
import Card from "../components/Card";
import '../components/Main.css'
import {Link} from "react-router-dom";
const Main = () => {
    return(
        <div className="main">
            <div className="main-container">
                <Link to='teams/rpg' style={{ textDecoration: 'none' }}><Card
                    imgUrl="https://upload.wikimedia.org/wikipedia/commons/a/a1/RPG-28_grenade_launcher_at_Interpolitex-2016_01.jpg"
                    title="RPG"
                    description="Games for Man Of Culture"
                /></Link>
                <Link to='teams/online' style={{ textDecoration: 'none' }}><Card
                    imgUrl="https://play-lh.googleusercontent.com/VSwHQjcAttxsLE47RuS4PqpC4LT7lCoSjE7Hx5AW_yCxtDvcnsHHvm5CTuL5BPN-uRTP"
                    title="ONLINE GAMES"
                    description="Dont Forget. Fifa and COD is for children!!!"
                /></Link>
                <Link to='teams/board' style={{ textDecoration: 'none' }}><Card
                    imgUrl="https://media-cldnry.s-nbcnews.com/image/upload/t_fit-1240w,f_auto,q_auto:best/newscms/2020_25/3390425/board-games-kr-2x1-tease-200616.jpg"
                    title="BOARD GAME"
                    description="No its not skateboard."
                /></Link>
            </div>
        </div>
    );
}

export default Main;