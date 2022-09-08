import axios from "../fetch/axiosinstance";

const fetchUrl = async (url) => {
    try {
        const response = await axios.get(url)
        console.log("In fetch: ",url)
        return response.data
    } catch (error) {
        console.log("In fetch: ",error.message)
    }
}

export default fetchUrl;