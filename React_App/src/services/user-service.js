
import { myAxios } from "./Helper";

export const signUp =(user)=>{
    console.log(user)
    return myAxios.post("/api/user/registion",user)
    .then((response)=>response.json());
};