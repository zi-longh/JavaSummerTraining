import { get, post } from './http'
const prefix = "/provide"
const getAllProvidesInfo = async (data) =>
  await get(`${prefix}/getAllProvidesInfo`, data)
const updateProvideById = async (id) => await post(`${prefix}/updateProvide`, id)
const deleteProvideById = async (id) => await get(`${prefix}/deleteProvideById`, id)
const addProvide = async (data) => await post(`${prefix}/addProvide`, data)
export default {
  updateProvideById,
  deleteProvideById,
  addProvide,
  getAllProvidesInfo,
}
