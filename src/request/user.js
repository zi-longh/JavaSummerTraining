import {post} from "./http.js"
const prefix ="/user"
const login = async(data) =>await post(`${prefix}/login`,data);
const register =async(data) => await post(`${prefix}/register`,data)
const getUserInfo = async (data) => await get(`${prefix}/getUserInfoById/${data}`)
export default {
  login,
  register,
  getUserInfo
}