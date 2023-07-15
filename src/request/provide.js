import { get, post,put,axiosDelete } from './http'
const prefix = "/provide"
// const getAllProvidesInfo = async (data) => 
  // await get(`${prefix}/getAllProvidesInfo`, data)
const updateProvideById = async (id) => await put(`${prefix}/updateProvide`, id)
const deleteProvideById = async (id) => await axiosDelete(`${prefix}/deleteProvideById`, id)
const addProvide = async (data) => await post(`${prefix}/addProvide`, data)
const getAllProvidesInfo = async () => await get("/data/getInfo2")
export default {
  updateProvideById,
  deleteProvideById,
  addProvide,
  getAllProvidesInfo,
}
