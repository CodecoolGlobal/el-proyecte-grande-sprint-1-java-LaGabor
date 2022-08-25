import React from "react";

const GameDescription = ({game}) => {
    function capitalize(str){
        if(str !== undefined) {
            return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
        }
    }

    return (
        <div>
            <div>
                <p>Minimum number of player: {game.minPlayer}</p>
                <p>Maximum number of player: {game.minPlayer}</p>
            </div>
            <div>
                <p>{capitalize(game.type)}</p>
            </div>
            <div>
                <p>{game.description}</p>
            </div>
        </div>
    )
}
export default GameDescription;