import React from "react";
import {useRef} from "react";

const fetchUrl = (url, func, method = 'GET', body = null) => {

    let requestOption = {method: method}
    if (method === 'POST') {
        requestOption = {
            method: method,
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(body)
        }
    }

    if (useRef.current === true) {
        fetch(url, requestOption)
            .then(response => response.json())
            .then(res => {
                func(res)
            })

            .catch(error => {
                console.error('There was an error!', error)
            });

    }
    useRef.current = true
}

export default fetchUrl;