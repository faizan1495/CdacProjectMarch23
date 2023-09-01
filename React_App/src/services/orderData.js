import { myAxios } from "./Helper";

export const setOderData =(oderdta)=>{
    return myAxios.
    post("/api/order/insertoder",oderdta)
    .then((response)=>response.json());
};