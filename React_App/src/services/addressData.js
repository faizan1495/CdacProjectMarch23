import { myAxios } from "./Helper";

export const addressIntoData =(addres)=>{
    return myAxios.
    post("/api/Address/insert",addres)
    .then((response)=>response.json());
};