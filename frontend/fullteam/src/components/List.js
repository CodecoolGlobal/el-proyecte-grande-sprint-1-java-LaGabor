import React, {useEffect, useState} from "react";

const List = ({fetch}) => {
    const [jsonFormatList, setList] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/game/all-games', setList);
    }, [])
    return (
        <div className='listContainer'>
            <ol>
                {jsonFormatList
                    .map((element, i) => <li key={i}>{Object.values(element)
                        .map((value, index) => <span key={index}>{value}</span>)}</li>)}

            </ol>
        </div>
    )
}
export default List;


