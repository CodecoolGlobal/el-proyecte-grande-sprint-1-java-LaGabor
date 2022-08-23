import './App.css';
import {useEffect, useState} from "react";

function App() {
    const [Game, setGame] = useState([]);

    const fetchUrl = (url, func, method = 'POST', body) => {

        const requestOption = {
            method: method,
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(body)
        }

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

    useEffect(() => {
        fetchUrl('http://localhost:8080/game/list/board', setGame, {gameType: 'BOARD'})
    }, [])

    return (
        <div className="App">
            <h1>FullTeam</h1>
        </div>
    );
}

export default App;
