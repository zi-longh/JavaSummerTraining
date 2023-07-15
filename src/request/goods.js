import { get, post,put,axiosDelete } from './http'
const prefix = "/goods";
const getGoodsInfo = async (data) => await get(`${prefix}/getGoodsInfo`, data)
const getAllGoodsInfo = async (data) => await get(`${prefix}/getAllGoodsInfo`, data)
const updateGoodById = async (id) => await put(`${prefix}/updateGood`, id)
const deleteGoodById = async (id) => await axiosDelete(`${prefix}/deleteGoodById/${id}`)
const addGood = async (data) => await post(`${prefix}/addGood`, data)
const getGoodsNum = async () => await get(`${prefix}/getGoodsNum`)
const getAvailableNum = async (data) => await post("/data/getAvailableNum",data);
export default {
  getGoodsInfo,
  updateGoodById,
  deleteGoodById,
  addGood,
  getAllGoodsInfo,
  getGoodsNum,
  getAvailableNum
}
