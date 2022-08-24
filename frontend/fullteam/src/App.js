import './App.css';
import {useEffect, useRef, useState} from "react";

function App() {
    const [Game, setGame] = useState([]);
    let effectRan = useRef(false);

    const fetchUrl = (url, func, body = {}, method = 'POST') => {

        const requestOption = {
            method: method,
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(body)
        }

        if (effectRan.current === true){
            fetch(url, requestOption)
                .then(response => response.json())
                .then(res => {
                    func(res)
                    console.log(res)
                })
                .catch(error => {
                    console.error('There was an error!', error)
                });

        }
        return () => {
            effectRan.current = true
        }
    }

    useEffect(() => {
        return fetchUrl('http://localhost:8080/game/list/board', setGame, {gameType: 'BOARD'})
    }, [])

    return (
        <div className="App">
            <h1>FullTeam</h1>
            {Game.map((game, index) => <p key={index}>{game})}</p>)}
        </div>
    );
}

export default App;
