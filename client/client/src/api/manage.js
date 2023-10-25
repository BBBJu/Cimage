import axios from "axios";
axios.defaults.baseURL="http://localhost:8081"
export const getAction = (url,parameters)=>{
    return axios({
        url:url,
        method:"get",
        params:parameters
    })
}
export const postAction = (url,data)=>{
    return axios({
        url:url,
        method:"post",
        data
    })
}
export const putAction = (url,data)=>{
    return axios({
        url:url,
        method:"put",
        data
    })
}
export const deleteAction = (url,parameters)=>{
    return axios({
        url:url,
        method:"delete",
        params:parameters
    })
}