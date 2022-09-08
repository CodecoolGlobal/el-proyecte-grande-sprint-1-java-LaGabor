import axios from "../fetch/axiosinstance";
import {useRef} from "react";

const fetchUrl = async (url) => {
    try {
        const response = await axios.get(url)
        console.log("In fetch: ",url)
        return response.data
    } catch (error) {
        console.log(error.message)
    }
}

export default fetchUrl;