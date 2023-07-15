import { axiosDelete, get, post,put } from './http'
const prefix='store'
const getStoresInfo = async (data) => await get( `${prefix}/getStoresInfo`, data)
const getAllStoresInfo = async (data) => await get(`data/getInfo1`, data)
const updateStore = async (data) => await put(`${prefix}/updateStore`, data)
const deleteStoreById = async (id) => await axiosDelete(`${prefix}/deleteStoreById/${id}`)
const addStore = async (data) => await post(`${prefix}/addStore`, data)

export default {
  getStoresInfo,
  updateStore,
  deleteStoreById,
  addStore,
  getAllStoresInfo,

}
