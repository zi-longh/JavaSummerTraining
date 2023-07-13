import { axiosDelete, get, post, put } from './http'
const prefix = 'storage'
const getStorageInfo = async (data) => await get(`${prefix}/getStoragesInfo`, data)
const getAllStorageInfo = async (data) => await get(`${prefix}/getAllStoragesInfo`, data)
const updateStorageById = async (id) => await put(`${prefix}/updateStorage`, id)
const deleteStorageById = async (id) => await axiosDelete(`${prefix}/deleteStorageById/${id}`)
const addStorage = async (data) => await post(`${prefix}/addStorage`, data)
const getStoragesNum = async () => await get(`${prefix}/getStoragesNum`)
export default {
  getStorageInfo,
  updateStorageById,
  deleteStorageById,
  addStorage,
  getAllStorageInfo,
  getStoragesNum,
}
